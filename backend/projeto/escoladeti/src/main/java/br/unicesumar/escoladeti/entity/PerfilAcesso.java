package br.unicesumar.escoladeti.entity;

import javax.persistence.Entity;

@Entity
public class PerfilAcesso extends Entidade {

    private static final long serialVersionUID = 1L;
    
    private String nome;

    public PerfilAcesso() {
    }
    
    public PerfilAcesso(Long id) {
        this.id = id;
    }
    
    public PerfilAcesso(Long id, String nome) {
        this.id = id;
        this.nome = nome.toUpperCase();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome.toUpperCase();
    }
    
}