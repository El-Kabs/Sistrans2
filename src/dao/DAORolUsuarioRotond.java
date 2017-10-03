package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import vos.Ingrediente;
import vos.RolUsuario;

public class DAORolUsuarioRotond {
	private ArrayList<Object> recursos;

	/**
	 * Atributo que genera la conexión a la base de datos
	 */
	private Connection conn;

	/**
	 * Metodo constructor que crea DAOVideo
	 * <b>post: </b> Crea la instancia del DAO e inicializa el Arraylist de recursos
	 */
	public DAORolUsuarioRotond() {
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
	public ArrayList<RolUsuario> darRolUsuario() throws SQLException, Exception {
		ArrayList<RolUsuario> RolUsuarios = new ArrayList<RolUsuario>();

		String sql = "SELECT * FROM ROL";

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			String nombre=rs.getString("ROL");
			RolUsuarios.add(new RolUsuario(nombre));
		}
		return RolUsuarios;
	}
	
	public ArrayList<RolUsuario> buscarRolUsuariosPorName(String name) throws SQLException, Exception {
		ArrayList<RolUsuario> RolUsuarios = new ArrayList<RolUsuario>();

		String sql = "SELECT * FROM ROL WHERE ROL ='" + name + "'";

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			String rol=rs.getString("ROL");
			RolUsuarios.add(new RolUsuario(rol));
		}
		return RolUsuarios;
	}

	/**
	 * Metodo que agrega el video que entra como parametro a la base de datos.
	 * @param usuario - el video a agregar. video !=  null
	 * <b> post: </b> se ha agregado el video a la base de datos en la transaction actual. pendiente que el video master
	 * haga commit para que el video baje  a la base de datos.
	 * @throws SQLException - Cualquier error que la base de datos arroje. No pudo agregar el video a la base de datos
	 * @throws Exception - Cualquier error que no corresponda a la base de datos
	 */
	public void addRolUsuario(RolUsuario RolUsuario) throws SQLException, Exception {
		
		String sql2 = "INSERT INTO ROL VALUES ('"+RolUsuario.getRol() +"')";

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
//	public void updateRolUsuario(RolUsuario RolUsuario) throws SQLException, Exception {
//
//		String sql2 = "UPDATE RolUsuario SET FECHA='"+RolUsuario.getFecha()+"', HORAS='"+RolUsuario.getHoras()+" NUMCOMENSALES = ' "+RolUsuario.getNumComensales()+"' RolUsuario_PREFERENCIA='"+RolUsuario.getRolUsuarioPreferencia()+"' WHERE ID='"+RolUsuario.getId()+"'"
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
	public void deleteRolUsuario(RolUsuario RolUsuario) throws SQLException, Exception {

		String sql = "DELETE FROM ROL";
		sql += " WHERE ROL = " + RolUsuario.getRol();

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
}
