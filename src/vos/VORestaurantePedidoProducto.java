package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class VORestaurantePedidoProducto {
	@JsonProperty(value="RestauranteProducto")
	private RestauranteProducto restaurante;
	@JsonProperty(value="PedidoProducto")
	private PedidoProducto pedido;
	public RestauranteProducto getRestaurante() {
		return restaurante;
	}
	public void setRestaurante(RestauranteProducto restaurante) {
		this.restaurante = restaurante;
	}
	public PedidoProducto getPedido() {
		return pedido;
	}
	public void setPedido(PedidoProducto pedido) {
		this.pedido = pedido;
	}
	public VORestaurantePedidoProducto(@JsonProperty(value="RestauranteProducto")RestauranteProducto restaurante, @JsonProperty(value="PedidoProducto")PedidoProducto pedido) {
		super();
		this.restaurante = restaurante;
		this.pedido = pedido;
	}
	
	
}
