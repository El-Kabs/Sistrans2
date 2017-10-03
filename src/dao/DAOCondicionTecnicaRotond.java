package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.CondicionTecnica;
import vos.Espacio;
import vos.Ingrediente;

public class DAOCondicionTecnicaRotond {
	/**
	 * Arraylits de recursos que se usan para la ejecución de sentencias SQL
	 */
	private ArrayList<Object> recursos;

	/**
	 * Atributo que genera la conexión a la base de datos
	 */
	private Connection conn;

	/**
	 * Metodo constructor que crea DAOVideo
	 * <b>post: </b> Crea la instancia del DAO e inicializa el Arraylist de recursos
	 */
	public DAOCondicionTecnicaRotond() {
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
	public ArrayList<CondicionTecnica> darCondicion() throws SQLException, Exception {
		ArrayList<CondicionTecnica> condiciones = new ArrayList<CondicionTecnica>();

		String sql = "SELECT * FROM CONDICION_TECNICA";

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			String condicion = rs.getString("CONDICION");
			condiciones.add(new CondicionTecnica(condicion));
		}
		return condiciones;
	}
	
	public ArrayList<CondicionTecnica> buscarIngredientesPorName(String condicion) throws SQLException, Exception {
		ArrayList<CondicionTecnica> condiciones = new ArrayList<CondicionTecnica>();

		String sql = "SELECT * FROM CONDICION_TECNICA WHERE CONDICION ='" + condicion + "'";

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			String condicion2 = rs.getString("CONDICION");
			condiciones.add(new CondicionTecnica(condicion2));
		}
		return condiciones;
	}
	/**
	 * Metodo que agrega el video que entra como parametro a la base de datos.
	 * @param usuario - el video a agregar. video !=  null
	 * <b> post: </b> se ha agregado el video a la base de datos en la transaction actual. pendiente que el video master
	 * haga commit para que el video baje  a la base de datos.
	 * @throws SQLException - Cualquier error que la base de datos arroje. No pudo agregar el video a la base de datos
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public void addCondicionTecnica(CondicionTecnica condicion) throws SQLException, Exception {
		
		String sql2 = "INSERT INTO CONDICION_TECNICA VALUES ('"+condicion.getCondicion()+"')";

		PreparedStatement prepStmt = conn.prepareStatement(sql2);
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
//	public void updateCondicionTecnica(CondicionTecnica condicion) throws SQLException, Exception {
//
//		String sql1 = "SELECT CONDICION FROM "
//		String condicionNueva = condicion.getCondicion();
//		String sql2 = "UPDATE CONDICION_TECNICA SET CONDICION = "+espacio.getAbierto()+", APTO_ESPECIALES="+espacio.getApto()+", CAPACIDAD="+espacio.getCapacidad()+" WHERE ID="+espacio.getId();
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
	public void deleteCondicionTecnica(CondicionTecnica condicion) throws SQLException, Exception {

		String sql = "DELETE FROM CONDICION_TECNICA";
		sql += " WHERE CONDICION = " + condicion.getCondicion();

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
}
