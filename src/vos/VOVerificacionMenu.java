package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class VOVerificacionMenu {
	
	@JsonProperty(value="restaurante")
	private Usuario restaurante;
	@JsonProperty(value="menu")
	private Menu menu;
	
	public VOVerificacionMenu(	@JsonProperty(value="restaurante")Usuario restaurante,	@JsonProperty(value="menu")Menu menu)
	{
		this.menu=menu;
		this.restaurante=restaurante;
	}

	public Usuario getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(Usuario retaurante) {
		this.restaurante = retaurante;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	


}
