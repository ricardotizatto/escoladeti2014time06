package br.unicesumar.escoladeti.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class UnidadeFederativa extends Entidade{
    private String nome;
    private String sigla;
    
    @ManyToOne
    @JoinColumn(name="id_pais")
    private Pais pais;
    
	public UnidadeFederativa(String nome, String sigla, Pais pais) {
		this.nome = nome;
		this.sigla = sigla;
		this.pais = pais;
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
	public Pais getPais() {
		return pais;
	}
	public void setPais(Pais pais) {
		this.pais = pais;
	}
    
    
}
