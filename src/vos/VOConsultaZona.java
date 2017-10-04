package vos;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;

public class VOConsultaZona {
	
	@JsonProperty(value="restaurante")
	private String restaurante;
	@JsonProperty(value="producto")
	private String producto;
	@JsonProperty(value="zona")
	private String zona;
	@JsonProperty(value="fecha")
	private Date fecha;
	
	public VOConsultaZona(@JsonProperty(value="restaurante")String restaurante,@JsonProperty(value="producto")String producto,@JsonProperty(value="zona")String zona,@JsonProperty(value="fecha")Date fecha)
	{
		this.restaurante=restaurante;
		this.producto=producto;
		this.zona=zona;
		this.fecha=fecha;
	}

	public String getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(String restaurante) {
		this.restaurante = restaurante;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	

}
