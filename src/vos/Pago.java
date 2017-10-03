package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Pago {
	
	@JsonProperty(value="pse")
	private Integer pse;
	
	public Pago(@JsonProperty(value="id")Integer pse)
	{
		this.pse=pse;
	}

	public Integer getPse() {
		return pse;
	}

	public void setPse(Integer pse) {
		this.pse = pse;
	}
	

}
