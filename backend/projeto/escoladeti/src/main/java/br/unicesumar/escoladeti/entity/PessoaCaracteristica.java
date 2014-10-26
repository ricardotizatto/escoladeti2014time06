package br.unicesumar.escoladeti.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class PessoaCaracteristica extends Entidade {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "pessoa_id",referencedColumnName = "id")
	@JsonBackReference
	private Pessoa pessoa;

	@ManyToOne
	@JoinColumn(name = "caracteristica_id",referencedColumnName = "id")
	private Caracteristica caracteristica;

	@OneToMany(mappedBy = "pessoaCaracteristica",cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	@JsonManagedReference
	private Set<VigenciaAssociado> vigenciaAssociados;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<VigenciaAssociado> getVigenciaAssociados() {
		return vigenciaAssociados;
	}

	public void setVigenciaAssociados(Set<VigenciaAssociado> vigenciaAssociados) {
		this.vigenciaAssociados = vigenciaAssociados;
	}

	public Caracteristica getCaracteristica() {
		return caracteristica;
	}

	public void setCaracteristica(Caracteristica caracteristica) {
		this.caracteristica = caracteristica;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public PessoaCaracteristica() {
	}
}
