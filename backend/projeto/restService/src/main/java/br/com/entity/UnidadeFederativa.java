package br.com.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
class UnidadeFederativa extends Entidade{
    private String nome;
    private String sigla;
    
    @ManyToOne
    private Pais pais;
    
    @OneToMany(mappedBy = "unidadeFederativa")
    private List<Cidade> cidades;
    
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
