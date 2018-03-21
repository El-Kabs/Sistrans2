package vos;

import java.sql.Timestamp;

import org.codehaus.jackson.annotate.JsonProperty;

public class VOConsulta {
	
	@JsonProperty(value="operador")
	Long id;
	@JsonProperty(value="dineroTotal")
	Double dineroTotal;
		
	public VOConsulta(@JsonProperty(value="operador")Long id,@JsonProperty(value="dineroTotal") Double dineroTotal) {
		super();
		this.id = id;
		this.dineroTotal = dineroTotal;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getDineroTotal() {
		return dineroTotal;
	}
	public void setDineroTotal(Double dineroTotal) {
		this.dineroTotal = dineroTotal;
	}
	
	
}
