package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class VOOferta {
	@JsonProperty(value="id")
	Long id;
	@JsonProperty(value="costo")
	Double costo;
	@JsonProperty(value="veces")
	Integer veces;
	
	
	public VOOferta(@JsonProperty(value="id")Long id, @JsonProperty(value="costo")Double costo, @JsonProperty(value="veces")Integer veces) {
		super();
		this.id = id;
		this.costo = costo;
		this.veces = veces;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Double getcosto() {
		return costo;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}

	public Integer getveces() {
		return veces;
	}

	public void setveces(Integer veces) {
		this.veces = veces;
	}

}
