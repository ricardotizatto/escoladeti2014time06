package br.com.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class ItemDeAcessoUsuario extends Entidade {
	private Date inicioVigencia;
	private Date fimVigencia;
	
	@ManyToOne
	private Usuario usuario;
	
	@ManyToOne
	private ItemDeAcesso itemDeAcesso;

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

	public ItemDeAcesso getItemDeAcesso() {
		return itemDeAcesso;
	}

	public void setItemDeAcesso(ItemDeAcesso itemDeAcesso) {
		this.itemDeAcesso = itemDeAcesso;
	}
}
