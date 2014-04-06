package br.com.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
class ItemDeAcesso extends Entidade {
	private String nomeComponente;
	
	@OneToMany(mappedBy="itemDeAcesso")
	private List<ItemDeAcessoUsuario> itensUsuario;
	
	@ManyToMany(mappedBy="itensDeAcesso")
	private List<PerfilDeAcesso> perfisDeAcesso;

	public String getNomeComponente() {
		return nomeComponente;
	}

	public void setNomeComponente(String nomeComponente) {
		this.nomeComponente = nomeComponente;
	}
}
