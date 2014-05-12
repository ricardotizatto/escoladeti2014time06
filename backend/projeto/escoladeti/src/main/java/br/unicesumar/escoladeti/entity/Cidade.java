package br.unicesumar.escoladeti.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Cidade extends Entidade {
    @Column(nullable=false)
    @NotEmpty
    private String nome;
    
    @Column(nullable=false)
    @NotEmpty
    @Temporal (TemporalType.DATE)
    private Date fundacao;
    @Column(nullable=false)
    @NotEmpty
    private String estado;
    
    public Cidade(){
    
    }
    
    public Cidade(Long id, String nome, Date fundacao, UnidadeFederativa unidadeFederativa, String estado){
        this.id = id;
        this.nome = nome;
        this.fundacao = fundacao;
        this.unidadeFederativa = unidadeFederativa;
        this.estado = estado;
    }
    
    public Cidade(String nome, Date fundacao, UnidadeFederativa unidadeFederativa, String estado) {
		this.nome = nome;
		this.fundacao = fundacao;
		this.unidadeFederativa = unidadeFederativa;
                this.estado = estado;
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
    
     public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
   
}
