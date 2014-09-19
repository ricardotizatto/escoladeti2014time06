package br.unicesumar.escoladeti.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;

@Entity
public class Produto extends Entidade {
    
    private String nome;


    public Produto() {
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
