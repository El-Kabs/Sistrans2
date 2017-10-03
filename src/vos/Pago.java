package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Pago {
	@JsonProperty(value="id")
	private Long id;
	
	@JsonProperty(value="pse")
	private Integer pse;
	
	public Pago(@JsonProperty(value="id")Long id, @JsonProperty(value="id")Integer pse)
	{
		super();
		this.id = id;
		this.pse=pse;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getPse() {
		return pse;
	}

	public void setPse(Integer pse) {
		this.pse = pse;
	}
	

}
