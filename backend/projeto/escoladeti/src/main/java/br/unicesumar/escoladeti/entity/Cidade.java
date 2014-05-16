package br.unicesumar.escoladeti.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Cidade extends Entidade {

    @Column(nullable = false)
    @NotEmpty
    private String nome;

    @Column(nullable = false)
    @NotNull
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fundacao;

    @ManyToOne
    @JoinColumn(name = "id_unidadefederativa", nullable = false)
    private UnidadeFederativa unidadeFederativa;

    public Cidade() {
    }

    public Cidade(String nome, Date fundacao, UnidadeFederativa unidadeFederativa) {
        this.nome = nome;
        this.fundacao = fundacao;
        this.unidadeFederativa = unidadeFederativa;
    }

    public Cidade(Long id, String nome, Date fundacao, UnidadeFederativa unidadeFederativa) {
        this.id = id;
        this.nome = nome;
        this.fundacao = fundacao;
        this.unidadeFederativa = unidadeFederativa;
    }
    
    

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
