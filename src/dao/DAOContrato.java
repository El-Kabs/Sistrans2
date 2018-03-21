package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import vos.EstadoContrato;
import vos.VOContrato;

public class DAOContrato {
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
	public DAOContrato() {
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
	public ArrayList<VOContrato> darContratos() throws SQLException, Exception {
		ArrayList<VOContrato> contratos = new ArrayList<VOContrato>();

		String sql = "SELECT * FROM CONTRATO";

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			Long id = rs.getLong("ID");
			Date fecha_inicio = rs.getDate("FECHA_INICIO");
			Date fecha_final = rs.getDate("FECHA_FINAL");
			Double costo = rs.getDouble("COSTO_TOTAL");
			EstadoContrato contrato = EstadoContrato.valueOf(rs.getString("ESTADO"));
			contratos.add(new VOContrato(id, fecha_inicio, fecha_final, costo, contrato));
		}
		return contratos;
	}


	/**
	 * Metodo que busca el/los videos con el nombre que entra como parametro.
	 * @param name - Nombre de el/los videos a buscar
	 * @return ArrayList con los videos encontrados
	 * @throws SQLException - Cualquier error que la base de datos arroje.
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public ArrayList<VOContrato> buscarContratoPorID(Long id) throws SQLException, Exception {
		ArrayList<VOContrato> contratos = new ArrayList<VOContrato>();

		String sql = "SELECT * FROM CONTRATO WHERE ID =" + id + "";
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			Long id2 = rs.getLong("ID");
			Date fecha_inicio = rs.getDate("FECHA_INICIO");
			Date fecha_final = rs.getDate("FECHA_FINAL");
			Double costo = rs.getDouble("COSTO_TOTAL");
			EstadoContrato contrato = EstadoContrato.valueOf(rs.getString("ESTADO"));
			contratos.add(new VOContrato(id2, fecha_inicio, fecha_final, costo, contrato));
		}
		return contratos;
	}

	/**
	 * Metodo que agrega el video que entra como parametro a la base de datos.
	 * @param usuario - el video a agregar. video !=  null
	 * <b> post: </b> se ha agregado el video a la base de datos en la transaction actual. pendiente que el video master
	 * haga commit para que el video baje  a la base de datos.
	 * @throws SQLException - Cualquier error que la base de datos arroje. No pudo agregar el video a la base de datos
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public void addContrato(VOContrato contrato) throws SQLException, Exception {
		
		String sql2 = "INSERT INTO CONTRATO VALUES ("+contrato.getId()+", "+contrato.getFechaInicio()+", "+contrato.getFechaFin()+", '"+contrato.getEstado()+"', "+contrato.getCostoTotal()+")";
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
	public void updateContrato(VOContrato contrato) throws SQLException, Exception {

		String sql2 = "UPDATE CONTRATO SET ESTADO = '"+contrato.getEstado()+"' WHERE ID="+contrato.getId();
		
		PreparedStatement prepStmt = conn.prepareStatement(sql2);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
}
