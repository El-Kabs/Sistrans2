package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class RolUsuario {
	
	@JsonProperty(value="rol")
	private String rol;
	
	public RolUsuario(@JsonProperty(value="rol")String rol)
	{
		this.rol=rol;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
	

}
