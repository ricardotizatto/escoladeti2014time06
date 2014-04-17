package br.com.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class UsuarioPerfilAcesso extends Entidade {
<<<<<<< HEAD:backend/projeto/restService/src/main/java/br/com/entity/UsuarioPerfilAcesso.java
=======
	@NotNull
>>>>>>> e9f212b8d39f7febeff4fe68d7fbd4905e3d6080:backend/projeto/restServiceTeste/src/main/java/br/com/entity/UsuarioPerfilAcesso.java
	private Date inicioVigencia;
	@NotNull
	private Date fimVigencia;
	@OneToOne
	private Usuario usuario;
	@ManyToOne
	@JoinColumn(name="id_perfil_acesso")
	private PerfilAcesso perfilAcesso;
	
	public UsuarioPerfilAcesso(Date inicioVigencia, Date fimVigencia, Usuario usuario, PerfilAcesso perfilAcesso) {
		this.inicioVigencia = inicioVigencia;
		this.fimVigencia = fimVigencia;
		this.usuario = usuario;
		this.perfilAcesso = perfilAcesso;
	}

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

}
