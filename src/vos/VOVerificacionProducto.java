package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class VOVerificacionProducto {
	@JsonProperty(value="restaurante")
	private Usuario restaurante;
	@JsonProperty(value="producto")
	private Producto producto;
	
	public VOVerificacionProducto(@JsonProperty(value="restaurante")Usuario restaurante, @JsonProperty(value="producto")Producto producto) 
	{
		this.restaurante=restaurante;
		this.producto=producto;
	}

	public Usuario getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(Usuario restaurante) {
		this.restaurante = restaurante;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
}
