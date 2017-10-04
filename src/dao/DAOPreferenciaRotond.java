package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vos.Categoria;
import vos.Ingrediente;
import vos.Menu;
import vos.Preferencia;

public class DAOPreferenciaRotond {
	private ArrayList<Object> recursos;

	/**
	 * Atributo que genera la conexión a la base de datos
	 */
	private Connection conn;

	/**
	 * Metodo constructor que crea DAOVideo
	 * <b>post: </b> Crea la instancia del DAO e inicializa el Arraylist de recursos
	 */
	public DAOPreferenciaRotond() {
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
	public ArrayList<Preferencia> darPreferencia(Integer idusu) throws SQLException, Exception {
		ArrayList<Preferencia> Preferencias = new ArrayList<Preferencia>();

		String sql = "SELECT * FROM PREFERENCIA WHERE ID_USUARIO="+idusu;

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			Categoria categoria = Categoria.valueOf(rs.getString("CATEGORIA"));
			double precioMin = rs.getDouble("PRECIO_MIN");
			double precioMax = rs.getDouble("PRECIO_MAX");
			Integer id= rs.getInt("ID_preferencia");
			String zona = rs.getString("ZONA");
			Integer usuario=rs.getInt("ID_USUARIO");
			Preferencias.add(new Preferencia(id, zona, precioMin, precioMax, categoria,usuario));
		}
		return Preferencias;
	}
	
	public ArrayList<Preferencia> buscarPreferenciasPorName(String name) throws SQLException, Exception {
		ArrayList<Preferencia> Preferencias = new ArrayList<Preferencia>();

		String sql = "SELECT * FROM PREFERENCIA WHERE NAME ='" + name + "'";

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			Categoria categoria = Categoria.valueOf(rs.getString("CATEGORIA"));
			double precioMin = rs.getDouble("PRECIO_MIN");
			double precioMax = rs.getDouble("PRECIO_MAX");
			Integer id= rs.getInt("ID_preferencia");
			String zona = rs.getString("ZONA_Preferencia");
			Integer usuario=rs.getInt("ID_USUARIO");
			Preferencias.add(new Preferencia(id, zona, precioMin, precioMax, categoria,usuario));
		}
		return Preferencias;
	}

	/**
	 * Metodo que agrega el video que entra como parametro a la base de datos.
	 * @param usuario - el video a agregar. video !=  null
	 * <b> post: </b> se ha agregado el video a la base de datos en la transaction actual. pendiente que el video master
	 * haga commit para que el video baje  a la base de datos.
	 * @throws SQLException - Cualquier error que la base de datos arroje. No pudo agregar el video a la base de datos
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public void addPreferencia(Preferencia Preferencia) throws SQLException, Exception {
		
		String sql2 = "INSERT INTO PREFERENCIA VALUES ('"+Preferencia.getZona()+"', '"+Preferencia.getPrecioMin()+"', '"+Preferencia.getPrecioMax()+"', '"+Preferencia.getCategoria()+"', '"+Preferencia.getUsuario()+"','"+Preferencia.getId()+"')";

		PreparedStatement prepStmt = conn.prepareStatement(sql2);
		System.out.println("SQL 2:"+sql2);
		recursos.add(prepStmt);
		prepStmt.executeQuery();

	}
	
	/**
	 * Metodo que actualiza el video que entra como parametro en la base de datos.
	 * @param usuario - el video a actualizar. video !=  null
	 * <b> post: </b> se ha actualizado el video en la base de datos en la transaction actual. pendiente que el video master
	 * haga commit para que los cambios bajen a la base de datos.
	 * @throws SQLException - Cualquier error que la base de datos arroje. No pudo actualizar el video.
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public void updatePreferencia(Preferencia preferencia) throws SQLException, Exception {

		String sql2 = "UPDATE PREFERENCIA SET ZONA='"+preferencia.getZona()+"', ID_USUARIO="+preferencia.getUsuario()+", PRECIO_MIN='"+preferencia.getPrecioMin()+" PRECIO_MAX = ' "+preferencia.getPrecioMax()+"' CATEGORIA='"+preferencia.getCategoria()+"' WHERE ID_PREFERENCIA="+preferencia.getId()+")"
		;
		PreparedStatement prepStmt = conn.prepareStatement(sql2);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
	
	public void updatePreferenciaUsuario(Preferencia preferencia) throws SQLException, Exception {

		String sql2 = "UPDATE PREFERENCIA SET ZONA='"+preferencia.getZona()+"', ID_PREFERENCIA="+preferencia.getId()+"', PRECIO_MIN='"+preferencia.getPrecioMin()+" PRECIO_MAX = ' "+preferencia.getPrecioMax()+"' CATEGORIA='"+preferencia.getCategoria()+"' WHERE ID_USUARIO="+preferencia.getUsuario()+")"
		;
		PreparedStatement prepStmt = conn.prepareStatement(sql2);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	/**
	 * Metodo que elimina el video que entra como parametro en la base de datos.
	 * @param usuario - el video a borrar. video !=  null
	 * <b> post: </b> se ha borrado el video en la base de datos en la transaction actual. pendiente que el video master
	 * haga commit para que los cambios bajen a la base de datos.
	 * @throws SQLException - Cualquier error que la base de datos arroje. No pudo actualizar el video.
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public void deletePreferencia(Preferencia Preferencia) throws SQLException, Exception {

		String sql = "DELETE FROM Preferencia";
		sql += " WHERE ID = " + Preferencia.getId();

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
	
	public Preferencia buscarPreferenciaDeUnUsuario(Integer idUsuario)throws SQLException, Exception{
		Preferencia preferencia = null;

		String sql = "SELECT * FROM PREFERENCIA WHERE ID_USUARIO =" + idUsuario;

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			Categoria categoria = Categoria.valueOf(rs.getString("CATEGORIA"));
			double precioMin = rs.getDouble("PRECIO_MIN");
			double precioMax = rs.getDouble("PRECIO_MAX");
			Integer id1= rs.getInt("ID_preferencia");
			String zona = rs.getString("ZONA_Preferencia");
			Integer usuario=rs.getInt("ID_USUARIO");
			preferencia = new Preferencia(id1, zona, precioMin, precioMax, categoria,usuario);
		}
		return preferencia;
	}
	
	public Preferencia buscarPreferenciaEspecificaDeUnUsuario(Integer idUsuario, Integer idPreferencia)throws SQLException, Exception{
		Preferencia preferencia = null;

		String sql = "SELECT * FROM PREFERENCIA WHERE ID_USUARIO =" + idUsuario +"AND ID_PREFERENCIA="+idPreferencia;

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			Categoria categoria = Categoria.valueOf(rs.getString("CATEGORIA"));
			double precioMin = rs.getDouble("PRECIO_MIN");
			double precioMax = rs.getDouble("PRECIO_MAX");
			Integer id1= rs.getInt("ID_preferencia");
			String zona = rs.getString("ZONA_Preferencia");
			Integer usuario=rs.getInt("ID_USUARIO");
			preferencia = new Preferencia(id1, zona, precioMin, precioMax, categoria,usuario);
		}
		return preferencia;
	}

	public Preferencia buscarPreferenciaPorId(Integer idPreferencia) throws SQLException, Exception {
		Preferencia preferencia = null;

		String sql = "SELECT * FROM PREFERENCIA WHERE ID_PREFERENCIA =" + idPreferencia;

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			Categoria categoria = Categoria.valueOf(rs.getString("CATEGORIA"));
			double precioMin = rs.getDouble("PRECIO_MIN");
			double precioMax = rs.getDouble("PRECIO_MAX");
			Integer id1= rs.getInt("ID_preferencia");
			String zona = rs.getString("ZONA_Preferencia");
			Integer usuario=rs.getInt("ID_USUARIO");
			preferencia = new Preferencia(id1, zona, precioMin, precioMax, categoria,usuario);
		}
		return preferencia;
	}
}
