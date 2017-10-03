package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Preferencia {
	
	@JsonProperty(value="zona")
	private String zona;
	@JsonProperty(value="precioMin")
	private double precioMin;
	@JsonProperty(value="precioMax")
	private double precioMax;
	@JsonProperty(value="categoria")
	private Categoria categoria;
	@JsonProperty(value="id")
	private Integer id;
	
	
	public Preferencia(@JsonProperty(value="id")Integer id,@JsonProperty(value="zona")String zona,@JsonProperty(value="precioMin")double precioMin,@JsonProperty(value="precioMax")double precioMax,@JsonProperty(value="categoria")Categoria categoria)
	{
		this.id=id;
		this.zona=zona;
		this.precioMin=precioMin;
		this.precioMax=precioMax;
		this.categoria=categoria;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public double getPrecioMin() {
		return precioMin;
	}

	public void setPrecioMin(double precioMin) {
		this.precioMin = precioMin;
	}

	public double getPrecioMax() {
		return precioMax;
	}

	public void setPrecioMax(double precioMax) {
		this.precioMax = precioMax;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	

}
