package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class VOOperadorContrato {
	@JsonProperty(value="operador")
	VOOperador operador;
	@JsonProperty(value="contratos")
	List<VOContrato> contratos;
			
	public VOOperadorContrato(@JsonProperty(value="operador") VOOperador operador, @JsonProperty(value="contratos") List<VOContrato> contratos) {
		super();
		this.operador = operador;
		this.contratos = contratos;
	}
	public VOOperador getOperador() {
		return operador;
	}
	public void setOperador(VOOperador operador) {
		this.operador = operador;
	}
	public List<VOContrato> getContratos() {
		return contratos;
	}
	public void setContratos(List<VOContrato> contratos) {
		this.contratos = contratos;
	}
	
	
}
