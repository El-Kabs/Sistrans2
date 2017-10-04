package vos;

import org.codehaus.jackson.annotate.JsonProperty;
import java.util.List;

public class PedidoProducto {
	@JsonProperty(value="producto")
	private List<Producto> producto;
	@JsonProperty(value="pedido")
	private Pedido pedido;
	
	
	public PedidoProducto(@JsonProperty(value="producto")List<Producto> producto, @JsonProperty(value="pedido")Pedido pedido) {
		super();
		this.producto = producto;
		this.pedido = pedido;
	}


	public List<Producto> getProducto() {
		return producto;
	}


	public void setProducto(List<Producto> producto) {
		this.producto = producto;
	}


	public Pedido getPedido() {
		return pedido;
	}


	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
}
