package br.unicesumar.escoladeti.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;

@Entity
public class Produto extends Entidade {
    
    private String nome;


    public Produto() {
    }

    public Produto(Long id) {
    	this.id = id;
	}
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
 
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Produto)) {
          return false;
        }
        Produto outroProduto = (Produto) obj;

        boolean igual = outroProduto.nome.equals(this.nome);
                
        return igual;
    }
    
    public static Produto of(Long id) {
		return new Produto(id);
	}
    
    
    
    
}
