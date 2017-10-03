package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import vos.Ingrediente;
import vos.Reserva;

public class DAOReservaRotond {
	private ArrayList<Object> recursos;

	/**
	 * Atributo que genera la conexión a la base de datos
	 */
	private Connection conn;

	/**
	 * Metodo constructor que crea DAOVideo
	 * <b>post: </b> Crea la instancia del DAO e inicializa el Arraylist de recursos
	 */
	public DAOReservaRotond() {
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
	public ArrayList<Reserva> darReserva() throws SQLException, Exception {
		ArrayList<Reserva> Reservas = new ArrayList<Reserva>();

		String sql = "SELECT * FROM RESERVA";

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			Integer id= rs.getInt("ID");
			Date fecha = rs.getDate("FECHA");
			int horas = rs.getInt("HORAS");
			int numComensales = rs.getInt("NUMCOMENSALES");
			String zonaPreferencia = rs.getString("ZONA_PREFERENCIA");
			
			Reservas.add(new Reserva(id, fecha, horas, numComensales, zonaPreferencia));
		}
		return Reservas;
	}
	
	public ArrayList<Reserva> buscarReservasPorName(String name) throws SQLException, Exception {
		ArrayList<Reserva> Reservas = new ArrayList<Reserva>();

		String sql = "SELECT * FROM Reserva WHERE NAME ='" + name + "'";

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			Integer id= rs.getInt("ID");
			Date fecha = rs.getDate("FECHA");
			int horas = rs.getInt("HORAS");
			int numComensales = rs.getInt("NUMCOMENSALES");
			String zonaPreferencia = rs.getString("ZONA_PREFERENCIA");
			Reservas.add(new Reserva(id, fecha, horas, numComensales, zonaPreferencia));
		}
		return Reservas;
	}

	/**
	 * Metodo que agrega el video que entra como parametro a la base de datos.
	 * @param usuario - el video a agregar. video !=  null
	 * <b> post: </b> se ha agregado el video a la base de datos en la transaction actual. pendiente que el video master
	 * haga commit para que el video baje  a la base de datos.
	 * @throws SQLException - Cualquier error que la base de datos arroje. No pudo agregar el video a la base de datos
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public void addReserva(Reserva Reserva) throws SQLException, Exception {
		
		String sql2 = "INSERT INTO Reserva VALUES ('"+Reserva.getId()+"', '"+Reserva.getFecha()+"', '"+Reserva.getHoras()+"', '"+Reserva.getNumComensales()+"', '"+Reserva.getZonaPreferencia()+"')";

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
	public void updateReserva(Reserva Reserva) throws SQLException, Exception {

		String sql2 = "UPDATE RESERVA SET FECHA='"+Reserva.getFecha()+"', HORAS='"+Reserva.getHoras()+" NUMCOMENSALES = ' "+Reserva.getNumComensales()+"' ZONA_PREFERENCIA='"+Reserva.getZonaPreferencia()+"' WHERE ID='"+Reserva.getId()+"'"
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
	public void deleteReserva(Reserva Reserva) throws SQLException, Exception {

		String sql = "DELETE FROM Reserva";
		sql += " WHERE ID = " + Reserva.getId();

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
}
