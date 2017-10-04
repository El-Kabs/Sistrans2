package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import vos.Ingrediente;
import vos.VOConsultaZona;
import vos.Zona;

public class DAOZonaRotond {
	private ArrayList<Object> recursos;

	/**
	 * Atributo que genera la conexión a la base de datos
	 */
	private Connection conn;

	/**
	 * Metodo constructor que crea DAOVideo
	 * <b>post: </b> Crea la instancia del DAO e inicializa el Arraylist de recursos
	 */
	public DAOZonaRotond() {
		recursos = new ArrayList<Object>();
	}

	/**
	 * Metodo que cierra todos los recursos que estan enel arreglo de recursos
	 * <b>post: </b> Todos los recurso del arreglo de recursos han sido cerrados
	 */
	public void cerrarRecursos() {
		for(Object ob : recursos){
			if(ob instanceof PreparedStatement)
				try {
					((PreparedStatement) ob).close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
		}
	}

	/**
	 * Metodo que inicializa la connection del DAO a la base de datos con la conexión que entra como parametro.
	 * @param con  - connection a la base de datos
	 */
	public void setConn(Connection con){
		this.conn = con;
	}
	
	/**
	 * Metodo que, usando la conexión a la base de datos, saca todos los videos de la base de datos
	 * <b>SQL Statement:</b> SELECT * FROM VIDEOS;
	 * @return Arraylist con los videos de la base de datos.
	 * @throws SQLException - Cualquier error que la base de datos arroje.
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public ArrayList<Zona> darZona() throws SQLException, Exception {
		ArrayList<Zona> Zonas = new ArrayList<Zona>();

		String sql = "SELECT * FROM ZONA";

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			String nombre=rs.getString("NOMBRE");
			Zonas.add(new Zona(nombre));
		}
		return Zonas;
	}
	/**
	 * @throws SQLException 
	 * 
	 */
	public ArrayList<VOConsultaZona> darZonaConInfo(String name) throws SQLException
	{
		ArrayList<VOConsultaZona> zonas= new ArrayList<>();
		String sql="SELECT NOMBRE_RESTAURANTE,PRODUCTO,ZONA_RESTAURANTE,FECHA FROM((SELECT * FROM\r\n" + 
				" (SELECT NOMBRE_RESTAURANTE,NOMBRE_PRODUCTO producto,ZONA_RESTAURANTE FROM\r\n" + 
				" (RESTAURANTE JOIN RESTAURANTE_PRODUCTO ON RESTAURANTE.NOMBRE=RESTAURANTE_PRODUCTO.NOMBRE_RESTAURANTE))t1 JOIN\r\n" + 
				"  PEDIDO_PRODUCTO ON t1.producto=PEDIDO_PRODUCTO.NOMBRE_PRODUCTO)t2\r\n" + 
				"  JOIN PEDIDO ON PEDIDO.ID=t2.ID_PEDIDO)\r\n" + 
				" WHERE ZONA_RESTAURANTE = '"+name +"'";
		PreparedStatement prepStmt= conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs=prepStmt.executeQuery();
		while(rs.next())
		{
			String restaurante= rs.getString("NOMBRE_RESTAURANTE");
			String producto=rs.getString("PRODUCTO");
			String zona=rs.getString("ZONA_RESTAURANTE");
			Date fecha= rs.getDate("FECHA");
			VOConsultaZona vo= new VOConsultaZona(restaurante, producto, zona, fecha);
			zonas.add(vo);
		}
		return zonas;
	}
	/**
	 * 
	 * @param name
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	
	public ArrayList<Zona> buscarZonasPorName(String name) throws SQLException, Exception {
		ArrayList<Zona> Zonas = new ArrayList<Zona>();

		String sql = "SELECT * FROM Zona WHERE NAME ='" + name + "'";

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			String nombre=rs.getString("NOMBRE");
			Zonas.add(new Zona(nombre));
		}
		return Zonas;
	}

	/**
	 * Metodo que agrega el video que entra como parametro a la base de datos.
	 * @param usuario - el video a agregar. video !=  null
	 * <b> post: </b> se ha agregado el video a la base de datos en la transaction actual. pendiente que el video master
	 * haga commit para que el video baje  a la base de datos.
	 * @throws SQLException - Cualquier error que la base de datos arroje. No pudo agregar el video a la base de datos
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public void addZona(Zona Zona) throws SQLException, Exception {
		
		String sql2 = "INSERT INTO ZONA VALUES ('"+Zona.getNombre() +"')";

		PreparedStatement prepStmt = conn.prepareStatement(sql2);
		System.out.println("SQL 2:"+sql2);
		recursos.add(prepStmt);
		prepStmt.executeQuery();

	}
	
//	/**
//	 * Metodo que actualiza el video que entra como parametro en la base de datos.
//	 * @param usuario - el video a actualizar. video !=  null
//	 * <b> post: </b> se ha actualizado el video en la base de datos en la transaction actual. pendiente que el video master
//	 * haga commit para que los cambios bajen a la base de datos.
//	 * @throws SQLException - Cualquier error que la base de datos arroje. No pudo actualizar el video.
//	 * @throws Exception - Cualquier error que no corresponda a la base de datos
//	 */
//	public void updateZona(Zona Zona) throws SQLException, Exception {
//
//		String sql2 = "UPDATE Zona SET FECHA='"+Zona.getFecha()+"', HORAS='"+Zona.getHoras()+" NUMCOMENSALES = ' "+Zona.getNumComensales()+"' ZONA_PREFERENCIA='"+Zona.getZonaPreferencia()+"' WHERE ID='"+Zona.getId()+"'"
//		;
//		PreparedStatement prepStmt = conn.prepareStatement(sql2);
//		recursos.add(prepStmt);
//		prepStmt.executeQuery();
//	}

	/**
	 * Metodo que elimina el video que entra como parametro en la base de datos.
	 * @param usuario - el video a borrar. video !=  null
	 * <b> post: </b> se ha borrado el video en la base de datos en la transaction actual. pendiente que el video master
	 * haga commit para que los cambios bajen a la base de datos.
	 * @throws SQLException - Cualquier error que la base de datos arroje. No pudo actualizar el video.
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public void deleteZona(Zona Zona) throws SQLException, Exception {

		String sql = "DELETE FROM ZONA";
		sql += " WHERE NOMBRE = '" + Zona.getNombre()+"'";

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
}
