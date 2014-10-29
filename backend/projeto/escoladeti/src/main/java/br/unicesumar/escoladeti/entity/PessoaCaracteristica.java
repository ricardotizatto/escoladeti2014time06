package br.unicesumar.escoladeti.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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

	@OneToOne(mappedBy = "pessoaCaracteristica",cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE}, orphanRemoval = true, fetch = FetchType.EAGER)
	@JsonManagedReference
	private VigenciaAssociado vigenciaAssociado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public VigenciaAssociado getVigenciaAssociado() {
		return vigenciaAssociado;
	}

	public void setVigenciaAssociado(VigenciaAssociado vigenciaAssociado) {
		this.vigenciaAssociado = vigenciaAssociado;
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
