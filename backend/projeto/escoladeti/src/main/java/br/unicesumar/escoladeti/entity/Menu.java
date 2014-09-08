package br.unicesumar.escoladeti.entity;

import javax.persistence.Entity;

@Entity
public class Menu extends Entidade {

    private String nome;

    public Menu() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
