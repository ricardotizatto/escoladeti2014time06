package br.unicesumar.escoladeti.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Cidade extends Entidade {
    private String nome;
    private Date fundacao;
    
    
    
    public Cidade(String nome, Date fundacao, UnidadeFederativa unidadeFederativa) {
		this.nome = nome;
		this.fundacao = fundacao;
		this.unidadeFederativa = unidadeFederativa;
	}

	@ManyToOne
    @JoinColumn(name="id_unidadefederativa", nullable =false)
    private UnidadeFederativa unidadeFederativa;
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getFundacao() {
        return fundacao;
    }

    public void setFundacao(Date fundacao) {
        this.fundacao = fundacao;
    }

    public UnidadeFederativa getUnidadeFederativa() {
        return unidadeFederativa;
    }

    public void setUnidadeFederativa(UnidadeFederativa unidadeFederativa) {
        this.unidadeFederativa = unidadeFederativa;
    }
}
