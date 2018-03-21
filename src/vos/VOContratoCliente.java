package vos;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

public class VOContratoCliente {
	@JsonProperty(value="contrato")
	List<VOContrato> contrato;
	@JsonProperty(value="contrato")
	List<VOCliente> cliente;
	
	
	public VOContratoCliente(@JsonProperty(value="contrato") List<VOContrato> contrato, @JsonProperty(value="contrato") List<VOCliente> cliente) {
		super();
		this.contrato = contrato;
		this.cliente = cliente;
	}
	
	public List<VOContrato> getContrato() {
		return contrato;
	}
	public void setContrato(List<VOContrato> contrato) {
		this.contrato = contrato;
	}
	public List<VOCliente> getCliente() {
		return cliente;
	}
	public void setCliente(List<VOCliente> cliente) {
		this.cliente = cliente;
	}
	
	
}
