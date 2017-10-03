package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class VOVerificacionIngrediente {
	@JsonProperty(value="restaurante")
	private Usuario restaurante;
	@JsonProperty(value="ingrediente")
	private Ingrediente ingrediente;
	
	public VOVerificacionIngrediente(@JsonProperty(value="restaurante")Usuario restaurante, @JsonProperty(value="ingrediente")Ingrediente ingrediente) 
	{
		this.restaurante=restaurante;
		this.ingrediente=ingrediente;
	}

	public Usuario getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(Usuario restaurante) {
		this.restaurante = restaurante;
	}

	public Ingrediente getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}
	
}
