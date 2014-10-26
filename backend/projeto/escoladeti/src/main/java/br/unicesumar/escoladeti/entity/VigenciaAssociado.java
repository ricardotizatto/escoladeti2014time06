package br.unicesumar.escoladeti.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class VigenciaAssociado extends Entidade{
	private static final long serialVersionUID = 1L;
	
	@Temporal(TemporalType.DATE)
	private Date vigencia;
	
	@ManyToOne
	@JoinColumn(name = "pessoacaracteristica_id",referencedColumnName = "id")
	@JsonBackReference
	private PessoaCaracteristica pessoaCaracteristica;

	public Date getVigencia() {
		return vigencia;
	}

	public void setVigencia(Date vigencia) {
		this.vigencia = vigencia;
	}
	
	public VigenciaAssociado(){
	}
}
