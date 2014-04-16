package br.unicesumar.escoladeti.entity;

import javax.persistence.Entity;

@Entity
public class Pais extends Entidade{
    private String nome;
    private String sigla;
    private int codPais;
    
    
	public Pais(String nome, String sigla, int codPais) {
		this.nome = nome;
		this.sigla = sigla;
		this.codPais = codPais;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public int getCodPais() {
		return codPais;
	}
	public void setCodPais(int codPais) {
		this.codPais = codPais;
	}
    
    
}
