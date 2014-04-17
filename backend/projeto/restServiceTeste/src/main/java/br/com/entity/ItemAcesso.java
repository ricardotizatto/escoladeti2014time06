package br.com.entity;

import javax.persistence.Entity;

@Entity
public class ItemAcesso extends Entidade {
	private String nomeComponente;
	
	public ItemAcesso(String nomeComponente) {
		this.nomeComponente = nomeComponente;
	}

	public String getNomeComponente() {
		return nomeComponente;
	}

	public void setNomeComponente(String nomeComponente) {
		this.nomeComponente = nomeComponente;
	}
}
