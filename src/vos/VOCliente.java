package vos;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

public class VOCliente {
	
	@JsonProperty(value="id")
	Long id;
	@JsonProperty(value="nombre")
	String nombre;
	@JsonProperty(value="vinculo")
	VinculoCliente vinculo;
	
	
	public VOCliente(@JsonProperty(value="id")Long id, @JsonProperty(value="nombre")String nombre, @JsonProperty(value="vinculo")VinculoCliente vinculo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.vinculo = vinculo;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public VinculoCliente getVinculo() {
		return vinculo;
	}
	public void setVinculo(VinculoCliente vinculo) {
		this.vinculo = vinculo;
	}
	
}
