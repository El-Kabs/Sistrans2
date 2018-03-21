package vos;

import java.sql.Timestamp;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;

public class VOContrato {

	@JsonProperty(value="id")
	Long id;
	@JsonProperty(value="fechaInicio")
	Timestamp fechaInicio;
	@JsonProperty(value="fechaFin")
	Timestamp fechaFin;
	@JsonProperty(value="costoTot")
	Double costoTotal;
	@JsonProperty(value="estado")
	EstadoContrato estado;
	
	
	
	
	
	public VOContrato(@JsonProperty(value="id")Long id, @JsonProperty(value="fechaInicio")Timestamp fechaInicio, @JsonProperty(value="fechaFin")Timestamp fechaFin,@JsonProperty(value="costoTot")Double costoTotal, @JsonProperty(value="estado")EstadoContrato estado) {
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





	public Timestamp getFechaInicio() {
		return fechaInicio;
	}





	public void setFechaInicio(Timestamp fechaInicio) {
		this.fechaInicio = fechaInicio;
	}





	public Timestamp getFechaFin() {
		return fechaFin;
	}





	public void setFechaFin(Timestamp fechaFin) {
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
