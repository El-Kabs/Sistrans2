package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class VOSeguro {
	@JsonProperty(value="id")
	Long id;
	@JsonProperty(value="nombre")
	String nombre;
	@JsonProperty(value="costo")
	Double costo;
	
	
	
	public VOSeguro(@JsonProperty(value="id")Long id, @JsonProperty(value="nombre")String nombre,@JsonProperty(value="costo")Double costo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.costo = costo;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Double getCosto() {
		return costo;
	}


	public void setCosto(Double costo) {
		this.costo = costo;
	}
}
