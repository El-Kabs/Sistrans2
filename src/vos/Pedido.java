package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Pedido {
	
	@JsonProperty(value="id")
	private Integer id;
	@JsonProperty(value="costoTotal")
	private double costoTotal;

    public Pedido(@JsonProperty(value="id")Integer id,@JsonProperty(value="costoTotal") double costoTotal)
    {
    	this.id=id;
    	this.costoTotal=costoTotal;
    }
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getCostoTotal() {
		return costoTotal;
	}

	public void setCostoTotal(double costoTotal) {
		this.costoTotal = costoTotal;
	}
	
	

}
