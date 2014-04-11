package br.com.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
class UsuarioPerfilAcesso extends Entidade {
	private Date inicioVigencia;
	private Date fimVigencia;
	
	@OneToOne(mappedBy="usuarioPerfilDeAcesso")
        @NotNull
	private Usuario usuario;
	
	@ManyToOne
	private PerfilDeAcesso perfilAcesso;

	public Date getInicioVigencia() {
		return inicioVigencia;
	}

	public void setInicioVigencia(Date inicioVigencia) {
		this.inicioVigencia = inicioVigencia;
	}

	public Date getFimVigencia() {
		return fimVigencia;
	}

	public void setFimVigencia(Date fimVigencia) {
		this.fimVigencia = fimVigencia;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public PerfilDeAcesso getPerfilAcesso() {
		return perfilAcesso;
	}

	public void setPerfilAcesso(PerfilDeAcesso perfilAcesso) {
		this.perfilAcesso = perfilAcesso;
	}
}
