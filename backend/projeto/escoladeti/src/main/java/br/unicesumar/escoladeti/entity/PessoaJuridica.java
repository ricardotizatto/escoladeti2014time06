package br.unicesumar.escoladeti.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class PessoaJuridica extends Entidade {
	@Column(nullable=false, unique=true)
    private String cnpj;
	@Column(nullable=false, unique=true)
    private String inscricaoEstadual;
	@Column(nullable=false)
    private String razaoSocial;
    private Date dataCriacao;
    
    public PessoaJuridica(String cnpj, String inscricaoEstadual, String razaoSocial, Date dataCriacao) {
		this.cnpj = cnpj;
		this.inscricaoEstadual = inscricaoEstadual;
		this.razaoSocial = razaoSocial;
		this.dataCriacao = dataCriacao;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}
    
    public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

}
