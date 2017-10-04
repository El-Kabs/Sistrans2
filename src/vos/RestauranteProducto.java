package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class RestauranteProducto {
	
	@JsonProperty(value="restaurante")
	private Restaurante restaurante;
	@JsonProperty(value="producto")
	private Producto producto;
	@JsonProperty(value="cantidad")
	private int cantidad;
	
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
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
	public RestauranteProducto(@JsonProperty(value="restaurante")Restaurante restaurante,@JsonProperty(value="producto")Producto producto ,@JsonProperty(value="cantidad")int cantidad) {
		super();
		this.restaurante = restaurante;
		this.producto = producto;
		this.cantidad = cantidad;
	}
	
}
