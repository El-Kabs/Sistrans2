package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class VOContratoServicio {
	@JsonProperty(value="contrato")
	List<VOContrato> contrato;
	@JsonProperty(value="servicio")
	List<VOServicio> servicio;
	
	public VOContratoServicio(@JsonProperty(value="contrato")List<VOContrato> contrato,@JsonProperty(value="servicio") List<VOServicio> servicio) {
		super();
		this.contrato = contrato;
		this.servicio = servicio;
	}
	
	public List<VOContrato> getContrato() {
		return contrato;
	}
	public void setContrato(List<VOContrato> contrato) {
		this.contrato = contrato;
	}
	public List<VOServicio> getServicio() {
		return servicio;
	}
	public void setServicio(List<VOServicio> servicio) {
		this.servicio = servicio;
	}
	
	
}
