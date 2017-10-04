package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class RestauranteProducto {
	
	@JsonProperty(value="restaurante")
	private Restaurante restaurante;
	@JsonProperty(value="producto")
	private Producto producto;
	public Restaurante getRestaurante() {
		return restaurante;
	}
	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public RestauranteProducto(Restaurante restaurante, Producto producto) {
		super();
		this.restaurante = restaurante;
		this.producto = producto;
	}
	
}
