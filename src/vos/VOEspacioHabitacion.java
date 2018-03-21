package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class VOEspacioHabitacion {
	@JsonProperty(value="id")
	Long id;
	@JsonProperty(value="habitacion")
	VOHabitacion habitacion;
	
	public VOEspacioHabitacion(@JsonProperty(value="id") Long id, @JsonProperty(value="habitacion")VOHabitacion habitacion) {
		super();
		this.id = id;
		this.habitacion = habitacion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public VOHabitacion getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(VOHabitacion habitacion) {
		this.habitacion = habitacion;
	}
}
