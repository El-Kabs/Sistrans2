package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class VOVerificacionZona {
	
	@JsonProperty(value="admin")
	private Usuario admin;
    @JsonProperty(value="zona")
	private Zona zona;
	
	public VOVerificacionZona(	@JsonProperty(value="admin")Usuario admin,	@JsonProperty(value="zona")Zona zona)
	{
		this.admin=admin;
		this.zona=zona;
	}

	public Usuario getAdmin() {
		return admin;
	}

	public void setAdmin(Usuario admin) {
		this.admin = admin;
	}

	public Zona getZona() {
		return zona;
	}

	public void setZona(Zona zona) {
		this.zona = zona;
	}
	
	

}
