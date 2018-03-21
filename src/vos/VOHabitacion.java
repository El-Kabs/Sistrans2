package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class VOHabitacion {
	@JsonProperty(value="id")
	Long id;
	@JsonProperty(value="compartida")
	Boolean compartida;
	@JsonProperty(value="capacidad")
	Integer capacidad;
	@JsonProperty(value="tipo")
	TipoHabitacion tipo;
	
	
	public VOHabitacion(@JsonProperty(value="id")Long id, @JsonProperty(value="compartida")Boolean compartida, @JsonProperty(value="capacidad")Integer capacidad,@JsonProperty(value="tipo")TipoHabitacion tipo) {
		super();
		this.id = id;
		this.compartida = compartida;
		this.capacidad = capacidad;
		this.tipo=tipo;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Boolean getCompartida() {
		return compartida;
	}

	public void setCompartida(Boolean compartida) {
		this.compartida = compartida;
	}

	public Integer getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}

	public TipoHabitacion getTipo() {
		return tipo;
	}

	public void setTipo(TipoHabitacion tipo) {
		this.tipo = tipo;
	}
}
