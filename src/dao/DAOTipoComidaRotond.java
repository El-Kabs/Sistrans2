package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.TipoComida;
import vos.TipoProducto;

public class DAOTipoComidaRotond {
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
	public DAOTipoComidaRotond() {
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
	public ArrayList<TipoComida> darTiposComida() throws SQLException, Exception {
		ArrayList<TipoComida> tiposComida = new ArrayList<TipoComida>();

		String sql = "SELECT * FROM TIPO_COMIDA";

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			String tipo = rs.getString("TIPO");
			tiposComida.add(new TipoComida(tipo));
		}
		return tiposComida;
	}
	
	public ArrayList<TipoComida> buscarTipoPorTipo(String tipo) throws SQLException, Exception {
		ArrayList<TipoComida> tipos = new ArrayList<TipoComida>();

		String sql = "SELECT * FROM TIPO_COMIDA WHERE TIPO ='" + tipo + "'";

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			String tipo2 = rs.getString("TIPO");
			tipos.add(new TipoComida(tipo2));
		}
		return tipos;
	}
	/**
	 * Metodo que agrega el video que entra como parametro a la base de datos.
	 * @param usuario - el video a agregar. video !=  null
	 * <b> post: </b> se ha agregado el video a la base de datos en la transaction actual. pendiente que el video master
	 * haga commit para que el video baje  a la base de datos.
	 * @throws SQLException - Cualquier error que la base de datos arroje. No pudo agregar el video a la base de datos
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public void addTipoComida(TipoComida tipo) throws SQLException, Exception {
		
		String sql2 = "INSERT INTO TIPO_COMIDA VALUES ('"+tipo.getTipo()+"')";

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
	public void deleteTipoComida(TipoComida tipo) throws SQLException, Exception {

		String sql = "DELETE FROM TIPO_COMIDA";
		sql += " WHERE TIPO = " + tipo.getTipo();

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
}
