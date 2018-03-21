package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class VOApartamentoSeguro {
	@JsonProperty(value="apartamento")
	VOApartamento apartamento;
	@JsonProperty(value="seguro")
	VOSeguro seguro;
	
	public VOApartamentoSeguro(@JsonProperty(value="apartamento") VOApartamento apartamento, @JsonProperty(value="seguro") VOSeguro seguro) {
		super();
		this.apartamento = apartamento;
		this.seguro = seguro;
	}
	
	public VOApartamento getApartamento() {
		return apartamento;
	}
	public void setApartamento(VOApartamento apartamento) {
		this.apartamento = apartamento;
	}
	public VOSeguro getSeguro() {
		return seguro;
	}
	public void setSeguro(VOSeguro seguro) {
		this.seguro = seguro;
	}
	
	
}
