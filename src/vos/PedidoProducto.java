package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class PedidoProducto {
	@JsonProperty(value="producto")
	private Producto producto;
	@JsonProperty(value="pedido")
	private Pedido pedido;
	
	
	public PedidoProducto(@JsonProperty(value="producto")Producto producto, @JsonProperty(value="pedido")Pedido pedido) {
		super();
		this.producto = producto;
		this.pedido = pedido;
	}
	
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
}
