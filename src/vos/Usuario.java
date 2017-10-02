/**-------------------------------------------------------------------
 * $Id$
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 *
 * Materia: Sistemas Transaccionales
 * Ejercicio: VideoAndes
 * Autor: Juan Felipe García - jf.garcia268@uniandes.edu.co
 * -------------------------------------------------------------------
 */
package vos;

import org.codehaus.jackson.annotate.*;

/**
 * Clase que representa un Video
 * @author Monitores 2017-20
 */
public class Usuario {

	//// Atributos

	/**
	 * Identificacion del usuario
	 */
	@JsonProperty(value="id")
	private Long id;

	/**
	 * Nombre del usuario
	 */
	@JsonProperty(value="nombre")
	private String nombre;

	/**
	 * Email del usuario
	 */
	@JsonProperty(value="email")
	private String email;
	
	/**
	 * Rol del usuario
	 */
	@JsonProperty(value="rol")
	private String rol;
	
	/**
	 * Password del usuario
	 */
	@JsonProperty(value="password")
	private String password;

	/**
	 * Metodo constructor de la clase video
	 * <b>post: </b> Crea el video con los valores que entran como parametro
	 * @param id - Id del video.
	 * @param name - Nombre del video. name != null
	 * @param duration - Duracion en minutos del video.
	 */
	public Usuario(@JsonProperty(value="id")Long id, @JsonProperty(value="nombre")String nombre,@JsonProperty(value="email")String email,@JsonProperty(value="rol") String rol,@JsonProperty(value="password") String password) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.rol = rol;
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
	
	


}
