package br.unicesumar.escoladeti.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class VigenciaAssociado extends Entidade{
	
	@Column(name = "vigencia")
	@Temporal(TemporalType.DATE)
	private Date vigencia;
	
	@OneToOne
	@JoinColumn(name = "pessoacaracteristica_id",referencedColumnName = "id")
	@JsonBackReference
	private PessoaCaracteristica pessoaCaracteristica;

	public Date getVigencia() {
		return vigencia;
	}

	public void setVigencia(Date vigencia) {
		this.vigencia = vigencia;
	}
	
	
	public PessoaCaracteristica getPessoaCaracteristica() {
		return pessoaCaracteristica;
	}

	public void setPessoaCaracteristica(PessoaCaracteristica pessoaCaracteristica) {
		this.pessoaCaracteristica = pessoaCaracteristica;
	}

	public VigenciaAssociado(){
	}
}
