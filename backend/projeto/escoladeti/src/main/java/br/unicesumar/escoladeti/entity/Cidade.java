package br.unicesumar.escoladeti.entity;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Cidade extends Entidade {

    @Column(nullable = false)
    @NotEmpty
    private String nome;

    @ManyToOne
    @JoinColumn(name = "unidadefederativaId", nullable = false)
    private UnidadeFederativa unidadeFederativa;

    public Cidade() {
    }

    public Cidade(String nome, UnidadeFederativa unidadeFederativa) {
        this.nome = nome;
        this.unidadeFederativa = unidadeFederativa;
    }

    public Cidade(Long id, String nome, UnidadeFederativa unidadeFederativa) {
        this.id = id;
        this.nome = nome;
        this.unidadeFederativa = unidadeFederativa;
    }

    public Cidade(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public UnidadeFederativa getUnidadeFederativa() {
        return unidadeFederativa;
    }

    public void setUnidadeFederativa(UnidadeFederativa unidadeFederativa) {
        this.unidadeFederativa = unidadeFederativa;
    }
    /* 
     @Override
     public boolean equals(Object obj) {
     if (obj == null) {
     return false;
     }
     if (getClass() != obj.getClass()) {
     return false;
     }
     final Cidade other = (Cidade) obj;
     if (!Objects.equals(this.nome, other.nome)) {
     return false;
     }
     if (!Objects.equals(this.fundacao, other.fundacao)) {
     return false;
     }
     if (!Objects.equals(this.unidadeFederativa, other.unidadeFederativa)) {
     return false;
     }
        
     return true;
     }*/

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.nome);
        hash = 79 * hash + Objects.hashCode(this.unidadeFederativa);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cidade other = (Cidade) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.unidadeFederativa, other.unidadeFederativa)) {
            return false;
        }
        return true;
    }

    public static Cidade of(Long id) {
        return new Cidade(id);
    }
}
