package br.unicesumar.escoladeti.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Caracteristica extends Entidade implements Serializable{
	private static final long serialVersionUID = 1L;

	@Column
	private String descricao;
	
	@ManyToMany(mappedBy = "caracteristicas")
	@JsonBackReference
	private Set<Pessoa> pessoas = new HashSet<Pessoa>();
	
	public Set<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(Set<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Caracteristica(){
	}

}
