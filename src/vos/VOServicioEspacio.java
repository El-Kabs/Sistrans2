package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class VOServicioEspacio {
	
	@JsonProperty(value="servicio")
	VOServicio servicio;
	@JsonProperty(value="apartamento")
	List<VOEspacioApartamento> apartamento;
	@JsonProperty(value="habitacion")
	List<VOEspacioHabitacion> habitacion;
		
	public VOServicioEspacio(@JsonProperty(value="servicio")VOServicio servicio, @JsonProperty(value="apartamento")List<VOEspacioApartamento> apartamento,
			@JsonProperty(value="habitacion")List<VOEspacioHabitacion> habitacion) {
		super();
		this.servicio = servicio;
		this.apartamento = apartamento;
		this.habitacion = habitacion;
	}
	
	public VOServicio getServicio() {
		return servicio;
	}
	public void setServicio(VOServicio servicio) {
		this.servicio = servicio;
	}
	public List<VOEspacioApartamento> getApartamento() {
		return apartamento;
	}
	public void setApartamento(List<VOEspacioApartamento> apartamento) {
		this.apartamento = apartamento;
	}
	public List<VOEspacioHabitacion> getHabitacion() {
		return habitacion;
	}
	public void setHabitacion(List<VOEspacioHabitacion> habitacion) {
		this.habitacion = habitacion;
	}
	
	
}
