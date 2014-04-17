package br.com.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Bairro extends Entidade {
	@NotNull
    private String nome;    
	
    @ManyToOne 
    @JoinColumn(name="id_cidade")
    private Cidade cidade;
    
    public Bairro(String nome, Cidade cidade) {
		this.nome = nome;
		this.cidade = cidade;
	}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
}
