package br.unicesumar.escoladeti.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Caracteristica extends Entidade implements Serializable{
	private static final long serialVersionUID = 1L;

	private String descricao;
	
	@OneToMany(mappedBy = "caracteristica",fetch = FetchType.EAGER)
	@JsonBackReference
	private Set<PessoaCaracteristica> pessoaCaracteristicas;
	
	public String getDescricao() {
		return descricao;
	}

	public Set<PessoaCaracteristica> getPessoaCaracteristicas() {
		return pessoaCaracteristicas;
	}

	public void setPessoaCaracteristicas(
			Set<PessoaCaracteristica> pessoaCaracteristicas) {
		this.pessoaCaracteristicas = pessoaCaracteristicas;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Caracteristica(){
	}

}
