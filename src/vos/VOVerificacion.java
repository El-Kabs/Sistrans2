package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class VOVerificacion {
	
	@JsonProperty(value="admin")
	private Usuario admin;
	@JsonProperty(value="usuario")
	private Usuario usuario;
	
	public VOVerificacion(	@JsonProperty(value="admin")Usuario admin,	@JsonProperty(value="usuario")Usuario usuario) 
	{
		this.admin=admin;
		this.usuario=usuario;
	}

	public Usuario getAdmin() {
		return admin;
	}

	public void setAdmin(Usuario admin) {
		this.admin = admin;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	

}
