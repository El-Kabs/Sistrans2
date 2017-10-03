package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Restaurante {

	/**
	 * Nombre del restaurante
	 */
	@JsonProperty(value="nombre")
	private String nombre;

	/**
	 * Nombre del representante del restaurante
	 */
	@JsonProperty(value="representante")
	private String representante;
	
	/**
	 * Pagina del restaurante
	 */
	@JsonProperty(value="pagina")
	private String pagina;
	
	/**
	 * Tipo del restaurante
	 */
	@JsonProperty(value="tipo")
	private String tipo;
	
	/**
	 * Zona del restaurante
	 */
	@JsonProperty(value="zona")
	private String zona;

	public Restaurante(@JsonProperty(value="nombre") String nombre, @JsonProperty(value="representante") String representante, @JsonProperty(value="pagina") String pagina, @JsonProperty(value="tipo") String tipo,@JsonProperty(value="zona")  String zona) {
		super();
		this.nombre = nombre;
		this.representante = representante;
		this.pagina = pagina;
		this.tipo = tipo;
		this.zona = zona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRepresentante() {
		return representante;
	}

	public void setRepresentante(String representante) {
		this.representante = representante;
	}

	public String getPagina() {
		return pagina;
	}

	public void setPagina(String pagina) {
		this.pagina = pagina;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}
	
}
