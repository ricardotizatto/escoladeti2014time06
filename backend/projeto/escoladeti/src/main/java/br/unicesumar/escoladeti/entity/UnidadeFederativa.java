package br.unicesumar.escoladeti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class UnidadeFederativa extends Entidade{
	@Column(nullable=false)
	@NotEmpty
    private String nome;
	@Column(nullable = false)
	@NotEmpty
    private String sigla;
    
    @ManyToOne
    @JoinColumn(name="id_pais",nullable =false)
    private Pais pais;
    
    public UnidadeFederativa() {
	}    
    
	public UnidadeFederativa(String nome, String sigla, Pais pais, Long id) {
		this.id = id;
		this.nome = nome;
		this.sigla = sigla;
		this.pais = pais;
	}

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
