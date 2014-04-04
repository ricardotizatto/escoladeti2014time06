package br.com.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
class PerfilDeAcesso extends Entidade {
	private String nome;
	
	@ManyToMany
	private List<ItemDeAcesso> itensDeAcesso;
	
	@OneToMany(mappedBy="perfilAcesso")
	private List<UsuarioPerfilAcesso> usuarioPerfisDeAcesso;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<ItemDeAcesso> getItensDeAcesso() {
		return itensDeAcesso;
	}

	public void setItensDeAcesso(List<ItemDeAcesso> itensDeAcesso) {
		this.itensDeAcesso = itensDeAcesso;
	}
}
