package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class VOOperadorOferta {
	@JsonProperty(value="operador")
	VOOperador operador;
	@JsonProperty(value="oferta")
	VOOferta oferta;
	
	public VOOperadorOferta(@JsonProperty(value="operador")VOOperador operador, @JsonProperty(value="oferta")VOOferta oferta) {
		super();
		this.operador = operador;
		this.oferta = oferta;
	}
	public VOOperador getOperador() {
		return operador;
	}
	public void setOperador(VOOperador operador) {
		this.operador = operador;
	}
	public VOOferta getOferta() {
		return oferta;
	}
	public void setOferta(VOOferta oferta) {
		this.oferta = oferta;
	}
	
	
}
