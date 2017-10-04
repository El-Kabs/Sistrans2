package vos;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;

public class Pedido {
	
	@JsonProperty(value="id")
	private Long id;
	@JsonProperty(value="costoTotal")
	private double costoTotal;
	@JsonProperty(value="id_usuario")
	private Long idUsuario;
	@JsonProperty(value="estado")
	private String estado;
	@JsonProperty(value="fecha")
    private Date fecha;
    public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Pedido(@JsonProperty(value="id")Long id,@JsonProperty(value="costoTotal") double costoTotal, @JsonProperty(value="id_usuario") Long idUsuario, @JsonProperty(value="estado") String estado,@JsonProperty(value="fecha")Date fecha)
    {
    	this.id=id;
    	this.costoTotal=costoTotal;
    	this.idUsuario=idUsuario;
    	this.estado = estado;
    	this.fecha=fecha;
    }
	
	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getCostoTotal() {
		return costoTotal;
	}

	public void setCostoTotal(double costoTotal) {
		this.costoTotal = costoTotal;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	

}
