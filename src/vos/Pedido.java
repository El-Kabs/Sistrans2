package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Pedido {
	
	@JsonProperty(value="id")
	private Long id;
	@JsonProperty(value="costoTotal")
	private double costoTotal;
	@JsonProperty(value="id_usuario")
	private Long idUsuario;

    public Pedido(@JsonProperty(value="id")Long id,@JsonProperty(value="costoTotal") double costoTotal, @JsonProperty(value="id_usuario") Long idUsuario)
    {
    	this.id=id;
    	this.costoTotal=costoTotal;
    	this.idUsuario=idUsuario;
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
	
	

}
