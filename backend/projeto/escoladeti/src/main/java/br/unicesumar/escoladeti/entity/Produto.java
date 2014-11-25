package br.unicesumar.escoladeti.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Produto extends Entidade {

    private String nome;
    private Long quantidade;

    @ManyToOne
    @JoinColumn(name = "id_estoque", referencedColumnName = "id")
    @JsonBackReference
    private Estoque estoque;

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

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
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
