package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class VOServicio {
	@JsonProperty(value="id")
	Long id;
	@JsonProperty(value="descripcion")
	String descripcion;
	@JsonProperty(value="costo")
	Double costo;
	
	
	
	public VOServicio(@JsonProperty(value="id")Long id, @JsonProperty(value="descripcion")String descripcion,@JsonProperty(value="costo")Double costo) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.costo = costo;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setdescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Double getCosto() {
		return costo;
	}


	public void setCosto(Double costo) {
		this.costo = costo;
	}
}
