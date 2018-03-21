package vos;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

public class VOOperador {
	@JsonProperty(value="id")
	Long id;
	@JsonProperty(value="nombre")
	String nombre;
	@JsonProperty(value="tipo")
	TipoOperador tipo;
	
	
	public VOOperador(@JsonProperty(value="id")Long id, @JsonProperty(value="nombre")String nombre, @JsonProperty(value="tipo")TipoOperador tipo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
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
	public TipoOperador getTipo() {
		return tipo;
	}
	public void setTipo(TipoOperador tipo) {
		this.tipo = tipo;
	}
	
	
}
