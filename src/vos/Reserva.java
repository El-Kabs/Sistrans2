package vos;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;

public class Reserva {
	
	@JsonProperty(value="id")
	private Integer id;
	@JsonProperty(value="fecha")
	private Date fecha;
	@JsonProperty(value="horas")
	private int horas;
	@JsonProperty(value="numComensales")
	private int numComensales;
	@JsonProperty(value="zonaPreferencia")
	private String zonaPreferencia;
	
	public Reserva(@JsonProperty(value="id")Integer id,@JsonProperty(value="fecha")Date fecha,@JsonProperty(value="horas")int horas,@JsonProperty(value="numComensales")int numComensales,@JsonProperty(value="zonaPreferencia")String zonaPreferencia)
	{
		this.id=id;
		this.fecha=fecha;
		this.horas=horas;
		this.numComensales=numComensales;
		this.zonaPreferencia=zonaPreferencia;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public int getNumComensales() {
		return numComensales;
	}

	public void setNumComensales(int numComensales) {
		this.numComensales = numComensales;
	}

	public String getZonaPreferencia() {
		return zonaPreferencia;
	}

	public void setZonaPreferencia(String zonaPreferencia) {
		this.zonaPreferencia = zonaPreferencia;
	}
	

}
