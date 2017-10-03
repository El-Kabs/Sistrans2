package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Espacio {
	/**
	 * ID del espacio
	 */
	@JsonProperty(value="id")
	private Long id;

	/**
	 * Nombre del representante del restaurante
	 */
	@JsonProperty(value="abierto")
	private int abierto;
	
	/**
	 * Pagina del restaurante
	 */
	@JsonProperty(value="apto")
	private int apto;
	
	/**
	 * Tipo del restaurante
	 */
	@JsonProperty(value="capacidad")
	private int capacidad;

	public Espacio(@JsonProperty(value="id")Long id, @JsonProperty(value="abierto")int abierto, @JsonProperty(value="apto")int apto,@JsonProperty(value="capacidad") int capacidad) {
		super();
		this.id = id;
		this.abierto = abierto;
		this.apto = apto;
		this.capacidad = capacidad;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getAbierto() {
		return abierto;
	}

	public void setAbierto(int abierto) {
		this.abierto = abierto;
	}

	public int getApto() {
		return apto;
	}

	public void setApto(int apto) {
		this.apto = apto;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
}
