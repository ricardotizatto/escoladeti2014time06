package br.unicesumar.escoladeti.entity;

import javax.persistence.Entity;

@Entity
public class Observacao extends Entidade{
	private String observacao;

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	
}
