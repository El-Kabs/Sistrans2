package vos;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;

public class VOContrato {

	@JsonProperty(value="id")
	Long id;
	@JsonProperty(value="fechaInicio")
	Date fechaInicio;
	@JsonProperty(value="fechaFin")
	Date fechaFin;
	@JsonProperty(value="costoTot")
	Double costoTotal;
	@JsonProperty(value="estado")
	EstadoContrato estado;
	
	
	
	
	
	public VOContrato(@JsonProperty(value="id")Long id, @JsonProperty(value="fechaInicio")Date fechaInicio, @JsonProperty(value="fechaFin")Date fechaFin,@JsonProperty(value="costoTot")Double costoTotal, @JsonProperty(value="estado")EstadoContrato estado) {
		super();
		this.id= id;
		this.fechaInicio = fechaInicio;
		this.fechaFin =fechaFin;
		this.costoTotal=costoTotal;
		this.estado=estado;
	}





	public Long getId() {
		return id;
	}





	public void setId(Long id) {
		this.id = id;
	}





	public Date getFechaInicio() {
		return fechaInicio;
	}





	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}





	public Date getFechaFin() {
		return fechaFin;
	}





	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}





	public Double getCostoTotal() {
		return costoTotal;
	}





	public void setCostoTotal(Double costoTotal) {
		this.costoTotal = costoTotal;
	}





	public EstadoContrato getEstado() {
		return estado;
	}





	public void setEstado(EstadoContrato estado) {
		this.estado = estado;
	}
}
