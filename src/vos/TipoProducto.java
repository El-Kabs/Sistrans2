package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class TipoProducto {
	
	@JsonProperty(value="tipo")
	private String tipo;
	
	public TipoProducto(@JsonProperty(value="tipo")String tipo)
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
