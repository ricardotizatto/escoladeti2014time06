
package br.unicesumar.escoladeti.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Estoque extends Entidade {
    @Column(nullable=false)
    @NotEmpty
    private String movimentacao;
    
    @Column(nullable = false)
    @NotEmpty
    private Long quantidade;
    
    @OneToMany
    @JoinColumn(name="produtoId",referencedColumnName = "id")
    private List<Produto> produtos;

    public Estoque() {
    }
    
    public String getMovimentacao() {
        return movimentacao;
    }

    public void setMovimentacao(String movimentacao) {
        this.movimentacao = movimentacao;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }


   
    
    
}
