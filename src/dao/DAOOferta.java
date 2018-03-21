package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import vos.VOOferta;

public class DAOOferta {
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
	public DAOOferta() {
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
	public ArrayList<VOOferta> darOfertas() throws SQLException, Exception {
		ArrayList<VOOferta> ofertas = new ArrayList<VOOferta>();

		String sql = "SELECT * FROM OFERTA";

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			Long id = rs.getLong("ID");
			Double costo = rs.getDouble("COSTO");
			Integer veces=rs.getInt("VECES");
			ofertas.add(new VOOferta(id, costo,veces));
		}
		return ofertas;
	}


	/**
	 * Metodo que busca el/los videos con el nombre que entra como parametro.
	 * @param name - Nombre de el/los videos a buscar
	 * @return ArrayList con los videos encontrados
	 * @throws SQLException - Cualquier error que la base de datos arroje.
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public ArrayList<VOOferta> buscarOfertaPorID(Long id) throws SQLException, Exception {
		ArrayList<VOOferta> ofertas = new ArrayList<VOOferta>();

		String sql = "SELECT * FROM OFERTA WHERE ID =" + id + "";
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			Long id2 = rs.getLong("ID");
			Double costo = rs.getDouble("COSTO");
			Integer veces=rs.getInt("VECES");
			ofertas.add(new VOOferta(id2, costo, veces));
		}
		return ofertas;
	}

	/**
	 * Metodo que agrega el video que entra como parametro a la base de datos.
	 * @param usuario - el video a agregar. video !=  null
	 * <b> post: </b> se ha agregado el video a la base de datos en la transaction actual. pendiente que el video master
	 * haga commit para que el video baje  a la base de datos.
	 * @throws SQLException - Cualquier error que la base de datos arroje. No pudo agregar el video a la base de datos
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public void addOferta(VOOferta oferta) throws SQLException, Exception {
		String sql = "INSERT INTO OFERTA (ID, COSTO, VECES) values(?, ?, ?)";
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		prepStmt.setLong(1, oferta.getId());
		prepStmt.setDouble(2, oferta.getcosto());
		prepStmt.setInt(3, oferta.getVeces());
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
	public void updateOferta(VOOferta oferta) throws SQLException, Exception {

		String sql2 = "UPDATE OFERTA SET COSTO = "+oferta.getcosto()+" WHERE ID="+oferta.getId();
		
		PreparedStatement prepStmt = conn.prepareStatement(sql2);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
	
	public void deleteOfertaEspacio(VOOferta oferta) throws SQLException, Exception {
		String sql = "DELETE FROM OFERTAESPACIO";
		sql += " WHERE ID_OFERTA = " + oferta.getId();

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
	public void deleteOfertaOperador(VOOferta oferta) throws SQLException, Exception {
		String sql = "DELETE FROM OPERADOROFERTA";
		sql += " WHERE ID_OFERTA = " + oferta.getId();

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
	public void deleteOferta(VOOferta oferta) throws SQLException, Exception {

		deleteOfertaEspacio(oferta);
		deleteOfertaOperador(oferta);
		String sql = "DELETE FROM OFERTA";
		sql += " WHERE ID = " + oferta.getId();

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
	
	public ArrayList<VOOferta> dar20Ofertas() throws SQLException, Exception {
		ArrayList<VOOferta> ofertas = new ArrayList<VOOferta>();

		String sql = "SELECT * FROM OFERTA ORDER BY VECES DESC";
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			Long id2 = rs.getLong("ID");
			Double costo = rs.getDouble("COSTO");
			Integer veces=rs.getInt("VECES");
			ofertas.add(new VOOferta(id2, costo, veces));
		}
		return ofertas;
	}
	
}
	