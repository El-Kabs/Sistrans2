package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class VOUsuarioConsulta {
	
	@JsonProperty(value="usuario")
	private Usuario usuario;
	@JsonProperty(value="preferencias")
	private List<Preferencia> preferencias;
	@JsonProperty(value="pedidos")
	private List<Pedido> pedidos;
	@JsonProperty(value="frecuencia")
	private double frecuencia;

	public VOUsuarioConsulta(@JsonProperty(value="usuario")Usuario usuario,@JsonProperty(value="pedidos")List<Pedido>pedidos,@JsonProperty(value="frecuencia") double frecuencia,@JsonProperty(value="preferencias")List<Preferencia>preferencias)
	{
		this.pedidos=pedidos;
		this.usuario=usuario;
		this.frecuencia=frecuencia;
		this.preferencias=preferencias;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public double getFrecuencia() {
		return frecuencia;
	}

	public void setFrecuencia(double frecuencia) {
		this.frecuencia = frecuencia;
	}

	public List<Preferencia> getPreferencias() {
		return preferencias;
	}

	public void setPreferencias(List<Preferencia> preferencias) {
		this.preferencias = preferencias;
	}
	
	
}
