package br.unicesumar.escoladeti.entity;

import javax.persistence.Entity;

@Entity
public class PerfilAcesso extends Entidade {

    private String nome;

    public PerfilAcesso() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}