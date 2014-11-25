package br.unicesumar.escoladeti.comando;

import java.util.Date;
import javax.validation.constraints.NotNull;

public class ComandoSalvarMovimentacao {

    @NotNull
    private Long tipo;
    
    @NotNull
    private Long quantidade;
    
    @NotNull
    private Date dataMovimentacao;
    
    @NotNull
    private Long pessoaOrigem;
    
    @NotNull
    private Long pessoaDestino;
        
    @NotNull
    private Long produto;

    public Long getTipo() {
        return tipo;
    }

    public void setTipo(Long tipo) {
        this.tipo = tipo;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }

    public Date getDataMovimentacao() {
        return dataMovimentacao;
    }

    public void setDataMovimentacao(Date dataMovimentacao) {
        this.dataMovimentacao = dataMovimentacao;
    }

    public Long getPessoaOrigem() {
        return pessoaOrigem;
    }

    public void setPessoaOrigem(Long pessoaOrigem) {
        this.pessoaOrigem = pessoaOrigem;
    }

    public Long getPessoaDestino() {
        return pessoaDestino;
    }

    public void setPessoaDestino(Long pessoaDestino) {
        this.pessoaDestino = pessoaDestino;
    }

    public Long getProduto() {
        return produto;
    }

    public void setProduto(Long produto) {
        this.produto = produto;
    }
}