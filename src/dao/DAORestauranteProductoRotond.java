package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.Pedido;
import vos.PedidoProducto;
import vos.Producto;

public class DAORestauranteProductoRotond {
	private ArrayList<Object> recursos;

	/**
	 * Atributo que genera la conexión a la base de datos
	 */
	private Connection conn;

	/**
	 * Metodo constructor que crea DAOVideo
	 * <b>post: </b> Crea la instancia del DAO e inicializa el Arraylist de recursos
	 */
	public DAORestauranteProductoRotond() {
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
	public ArrayList<PedidoProducto> darPedidoProducto() throws SQLException, Exception {
		ArrayList<PedidoProducto> pedidosProductos = new ArrayList<PedidoProducto>();
		DAOPedidoRotond pedidoDao = new DAOPedidoRotond();
		DAOProductoRotond productoDAO = new DAOProductoRotond();
		String sql = "SELECT * FROM PEDIDO_PRODUCTO";

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			Long idPedido = rs.getLong("ID_PEDIDO");
			String nombreProducto = rs.getString("NOMBRE_PRODUCTO");
			Pedido pedido = pedidoDao.buscarPedidoPorId(idPedido);
			ArrayList<Producto> producto = productoDAO.buscarProductoPorName(nombreProducto);
			pedidosProductos.add(new PedidoProducto(producto, pedido));
		}
		return pedidosProductos;
	}

	public void addPedidoProducto(PedidoProducto pedidoProducto) throws SQLException, Exception {
		
		DAOPedidoRotond pedidoDao = new DAOPedidoRotond();
		DAOProductoRotond productoDAO = new DAOProductoRotond();
		
		for(int i = 0; i<pedidoProducto.getProducto().size(); i++) {
			String sql2 = "INSERT INTO PEDIDO_PRODUCTO VALUES ("+pedidoProducto.getPedido().getId()+", '"+pedidoProducto.getProducto().get(i).getNombre()+"')";
			PreparedStatement prepStmt = conn.prepareStatement(sql2);
			recursos.add(prepStmt);
			prepStmt.executeQuery();
		}
	
	}
	
	public PedidoProducto buscarPedidoProductoPorId(Long id) throws SQLException, Exception 
	{
		PedidoProducto pedidoProducto = null;
		
		DAOPedidoRotond pedidoDao = new DAOPedidoRotond();
		DAOProductoRotond productoDAO = new DAOProductoRotond();

		String sql = "SELECT * FROM PEDIDO_PRODUCTO WHERE ID_PEDIDO =" + id;

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			Long idPedido = rs.getLong("ID_PEDIDO");
			String nombreProducto = rs.getString("NOMBRE_PRODUCTO");
			Pedido pedido = pedidoDao.buscarPedidoPorId(idPedido);
			ArrayList<Producto> producto = productoDAO.buscarProductoPorName(nombreProducto);
			pedidoProducto = new PedidoProducto(producto, pedido);
		}
		return pedidoProducto;
	}
	
	public PedidoProducto buscarPedidoProductoPorName(String name) throws SQLException, Exception 
	{
		PedidoProducto pedidoProducto = null;
		
		DAOPedidoRotond pedidoDao = new DAOPedidoRotond();
		DAOProductoRotond productoDAO = new DAOProductoRotond();

		String sql = "SELECT * FROM PEDIDO_PRODUCTO WHERE NOMBRE_PRODUCTO ='" + name+"'";

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			Long idPedido = rs.getLong("ID_PEDIDO");
			String nombreProducto = rs.getString("NOMBRE_PRODUCTO");
			Pedido pedido = pedidoDao.buscarPedidoPorId(idPedido);
			ArrayList<Producto> producto = productoDAO.buscarProductoPorName(nombreProducto);
			pedidoProducto = new PedidoProducto(producto, pedido);
		}
		return pedidoProducto;
	}
}
