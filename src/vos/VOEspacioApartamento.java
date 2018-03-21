package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class VOEspacioApartamento {
	
	@JsonProperty(value="id")
	Long id;
	@JsonProperty(value="apartamento")
	VOApartamento apartamento;

	public VOEspacioApartamento(@JsonProperty(value="id") Long id, @JsonProperty(value="apartamento")VOApartamento apartamento) {
		super();
		this.id = id;
		this.apartamento = apartamento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public VOApartamento getApartamento() {
		return apartamento;
	}

	public void setApartamento(VOApartamento apartamento) {
		this.apartamento = apartamento;
	}
}
