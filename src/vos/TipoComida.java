package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class TipoComida {
	
	@JsonProperty(value="tipo")
	private String tipo;

	public TipoComida(@JsonProperty(value="tipo")String tipo)
	{
		this.tipo=tipo;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	

}
