package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import vos.EstadoContrato;
import vos.VOConsulta;
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
			Timestamp fecha_inicio = rs.getTimestamp("FECHA_INICIO");
			Timestamp fecha_final = rs.getTimestamp("FECHA_FINAL");
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
			Timestamp fecha_inicio = rs.getTimestamp("FECHA_INICIO");
			Timestamp fecha_final = rs.getTimestamp("FECHA_FINAL");
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
		String sql = "INSERT INTO CONTRATO(ID, FECHA_INICIO, FECHA_FINAL, COSTO_TOTAL, ESTADO) values(?, ?, ?, ?, ?)";
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		prepStmt.setLong(1, contrato.getId());
		prepStmt.setTimestamp(2, contrato.getFechaInicio());
		prepStmt.setTimestamp(3, contrato.getFechaFin());
		prepStmt.setDouble(4, contrato.getCostoTotal());
		prepStmt.setString(5, ""+contrato.getEstado());
		System.out.println("SQL:"+sql);
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
	
	/**
	 * Metodo que busca el/los videos con el nombre que entra como parametro.
	 * @param name - Nombre de el/los videos a buscar
	 * @return ArrayList con los videos encontrados
	 * @throws SQLException - Cualquier error que la base de datos arroje.
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public ArrayList<VOConsulta> dineroPorOperador() throws SQLException, Exception {
		ArrayList<VOConsulta> contratos = new ArrayList<VOConsulta>();
		Timestamp fechaHoy = new Timestamp(System.currentTimeMillis());
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, -365);
		long yearago = cal.getTimeInMillis();
		Timestamp comparar = new Timestamp(yearago);
		String finalf = new SimpleDateFormat("dd/MM/yy").format(fechaHoy);
		String inicialf = new SimpleDateFormat("dd/MM/yy").format(comparar);
		String sql = "SELECT b.ID_OPERADOR AS operador, SUM(a.COSTO_TOTAL) As suma FROM CONTRATO a JOIN OPERADORCONTRATO b ON a.ID = b.ID_CONTRATO WHERE a.FECHA_FINAL BETWEEN '"+inicialf+"' AND '"+finalf+"' GROUP BY ID_OPERADOR";
		System.out.println(sql);
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			Long id2 = rs.getLong("operador");
			Double dinero = rs.getDouble("suma");
			contratos.add(new VOConsulta(id2, dinero));
		}
		return contratos;
	}
}
