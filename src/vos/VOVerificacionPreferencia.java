package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class VOVerificacionPreferencia {
	
	@JsonProperty(value="preferencia")
	private Preferencia preferencia;
	@JsonProperty(value="usuario")
	private Usuario usuario;
	
	public VOVerificacionPreferencia(@JsonProperty(value="preferencia")Preferencia preferencia,	@JsonProperty(value="usuario")Usuario usuario)
	{
		this.preferencia=preferencia;
		this.usuario=usuario;
	}

	public Preferencia getPreferencia() {
		return preferencia;
	}

	public void setPreferencia(Preferencia preferencia) {
		this.preferencia = preferencia;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
