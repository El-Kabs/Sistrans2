package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class VOOperadorEspacio {
	@JsonProperty(value="operador")
	VOOperador operador;
	@JsonProperty(value="apartamento")
	VOEspacioApartamento apartamento;
	@JsonProperty(value="habitacion")
	VOEspacioHabitacion habitacion;
	
	
	public VOOperadorEspacio(@JsonProperty(value="operador")VOOperador operador,@JsonProperty(value="apartamento")VOEspacioApartamento apartamento,@JsonProperty(value="habitacion") VOEspacioHabitacion habitacion) {
		super();
		this.operador = operador;
		this.apartamento = apartamento;
		this.habitacion = habitacion;
	}
	
	public VOOperador getOperador() {
		return operador;
	}
	public void setOperador(VOOperador operador) {
		this.operador = operador;
	}
	public VOEspacioApartamento getApartamento() {
		return apartamento;
	}
	public void setApartamento(VOEspacioApartamento apartamento) {
		this.apartamento = apartamento;
	}
	public VOEspacioHabitacion getHabitacion() {
		return habitacion;
	}
	public void setHabitacion(VOEspacioHabitacion habitacion) {
		this.habitacion = habitacion;
	}
	
	
}
