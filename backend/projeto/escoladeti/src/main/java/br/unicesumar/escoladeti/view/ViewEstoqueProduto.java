package br.unicesumar.escoladeti.view;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "viewestoqueproduto")
public class ViewEstoqueProduto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;
    private String nome;
    private Long quantidade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }
    
}
