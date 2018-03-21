package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class VOApartamento {
	@JsonProperty(value="id")
	Long id;
	@JsonProperty(value="tipo")
	String tipo;
	@JsonProperty(value="habitaciones")
	Integer habitaciones;
	
	
	public VOApartamento(@JsonProperty(value="id")Long id, @JsonProperty(value="tipo")String tipo, @JsonProperty(value="habitaciones")Integer habitaciones) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.habitaciones = habitaciones;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String gettipo() {
		return tipo;
	}
	public void settipo(String tipo) {
		this.tipo = tipo;
	}
	public Integer gethabitaciones() {
		return habitaciones;
	}
	public void sethabitaciones(Integer habitaciones) {
		this.habitaciones = habitaciones;
	}
}
