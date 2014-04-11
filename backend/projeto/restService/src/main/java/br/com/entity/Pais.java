package br.com.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
class Pais extends Entidade{
    private String nome;
    private String sigla;
    private int codPais;
    
    @OneToMany(mappedBy="pais")
    private List<UnidadeFederativa> estados;
    
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
