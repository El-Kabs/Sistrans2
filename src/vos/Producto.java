package vos;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

public class Producto {
	
	@JsonProperty(value="nombre")
	private String nombre;
	@JsonProperty(value="info")
	private String info;
	@JsonProperty(value="traduccion")
	private String traduccion;
	@JsonProperty(value="preparacion")
	private String preparacion;
	@JsonProperty(value="costoProduccion")
	private double costoProduccion;
	@JsonProperty(value="precio")
	private double precio;
	@JsonProperty(value="categoria")
	private Categoria categoria;
	@JsonProperty(value="cantidad")
	private double cantidad;
	
	
	public Producto(@JsonProperty(value="nombre")String nombre,@JsonProperty(value="info")String info,@JsonProperty(value="traduccion")String traduccion,@JsonProperty(value="preparacion")String preparacion,@JsonProperty(value="costoProduccion")double costoProduccion,@JsonProperty(value="precio")double precio,@JsonProperty(value="categoria")Categoria categoria,	@JsonProperty(value="cantidad")double cantidad)
	{
		this.nombre=nombre;
		this.info=info;
		this.traduccion=traduccion;
		this.preparacion=preparacion;
		this.costoProduccion=costoProduccion;
		this.precio=precio;
		this.categoria=categoria;
		this.cantidad=cantidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getTraduccion() {
		return traduccion;
	}

	public void setTraduccion(String traduccion) {
		this.traduccion = traduccion;
	}

	public String getPreparacion() {
		return preparacion;
	}

	public void setPreparacion(String preparacion) {
		this.preparacion = preparacion;
	}

	public double getCostoProduccion() {
		return costoProduccion;
	}

	public void setCostoProduccion(double costoProduccion) {
		this.costoProduccion = costoProduccion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
}
