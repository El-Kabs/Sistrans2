package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class CondicionTecnica {
	
	@JsonProperty(value="condicion")
	private String condicion;
	
	public CondicionTecnica(@JsonProperty(value="condicion")String condicion)
	{
		this.condicion=condicion;
	}

	public String getCondicion() {
		return condicion;
	}

	public void setCondicion(String condicion) {
		this.condicion = condicion;
	}
	
	

}
