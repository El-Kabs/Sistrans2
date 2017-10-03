package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Menu {
	/**
	 * ID del menu
	 */
	@JsonProperty(value="id")
	private Long id;
	
	/**
	 * Nombre del menu
	 */
	@JsonProperty(value="nombre")
	private String nombre;

	/**
	 * Costo del menu
	 */
	@JsonProperty(value="costo")
	private double costo;
	
	/**
	 * Nombre del restaurante dueño del menu
	 */
	@JsonProperty(value="restaurante")
	private String restaurante;

	public Menu(@JsonProperty(value="id")Long id, @JsonProperty(value="nombre")String nombre, @JsonProperty(value="costo")double costo, @JsonProperty(value="restaurante")String restaurante) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.costo = costo;
		this.restaurante = restaurante;
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

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public String getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(String restaurante) {
		this.restaurante = restaurante;
	}
	
	
	
	
}
