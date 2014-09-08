package br.unicesumar.escoladeti.entity;

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

    public Cidade(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome.toUpperCase();
    }

    public UnidadeFederativa getUnidadeFederativa() {
        return unidadeFederativa;
    }

    public void setUnidadeFederativa(UnidadeFederativa unidadeFederativa) {
        this.unidadeFederativa = unidadeFederativa;
    }

    public static Cidade of(Long id) {
        if(id == null) {
            return null;
        }
        return new Cidade(id);
    }
}
