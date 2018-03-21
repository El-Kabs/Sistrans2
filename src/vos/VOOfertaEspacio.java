package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class VOOfertaEspacio {
	
	@JsonProperty(value="oferta")
	VOOferta oferta;
	@JsonProperty(value="espacioApartamento")
	VOEspacioApartamento espacioApartamento;
	@JsonProperty(value="espacioHabitacion")
	VOEspacioHabitacion espacioHabitacion;
	
	public VOOfertaEspacio(@JsonProperty(value="oferta")VOOferta oferta, @JsonProperty(value="espacioApartamento")VOEspacioApartamento espacioApartamento,
			@JsonProperty(value="espacioHabitacion")VOEspacioHabitacion espacioHabitacion) {
		super();
		this.oferta = oferta;
		this.espacioApartamento = espacioApartamento;
		this.espacioHabitacion = espacioHabitacion;
	}

	public VOOferta getOferta() {
		return oferta;
	}

	public void setOferta(VOOferta oferta) {
		this.oferta = oferta;
	}

	public VOEspacioApartamento getEspacioApartamento() {
		return espacioApartamento;
	}

	public void setEspacioApartamento(VOEspacioApartamento espacioApartamento) {
		this.espacioApartamento = espacioApartamento;
	}

	public VOEspacioHabitacion getEspacioHabitacion() {
		return espacioHabitacion;
	}

	public void setEspacioHabitacion(VOEspacioHabitacion espacioHabitacion) {
		this.espacioHabitacion = espacioHabitacion;
	}
	
	
	
	
}
