package br.unicesumar.escoladeti.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import static org.parboiled.common.Preconditions.checkNotNull;

@Entity
public class Movimentacao extends Entidade {

    private Long tipo;
    private boolean extornado;
    private Long quantidade;

    @Temporal(TemporalType.DATE)
    private Date dataMovimentacao;

    @ManyToOne
    @JoinColumn(name = "id_origem")
    private Pessoa pessoaOrigem;

    @ManyToOne
    @JoinColumn(name = "id_destino")
    private Pessoa pessoaDestino;

    @OneToOne
    @JoinColumn(name = "id_produto", referencedColumnName = "id")
    private Produto produto;

    public Long getTipo() {
        return tipo;
    }

    public void setTipo(Long tipo) {
        this.tipo = tipo;
    }

    public boolean isExtornado() {
        return extornado;
    }

    public void setExtornado(boolean extornado) {
        this.extornado = extornado;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Date getDataMovimentacao() {
        return dataMovimentacao;
    }

    public void setDataMovimentacao(Date dataMovimentacao) {
        this.dataMovimentacao = dataMovimentacao;
    }

    public Pessoa getPessoaOrigem() {
        return pessoaOrigem;
    }

    public void setPessoaOrigem(Pessoa pessoaOrigem) {
        this.pessoaOrigem = pessoaOrigem;
    }

    public Pessoa getPessoaDestino() {
        return pessoaDestino;
    }

    public void setPessoaDestino(Pessoa pessoaDestino) {
        this.pessoaDestino = pessoaDestino;
    }

    public static MovimentacaoBuilder builder() {
        return new MovimentacaoBuilder();
    }

    public static class MovimentacaoBuilder {

        private Long id;
        private Long tipo;
        private Long quantidade;
        private Date dataMovimentacao;
        private Pessoa pessoaOrigem;
        private Pessoa pessoaDestino;
        private Produto produto;

        public MovimentacaoBuilder() {
        }

        public MovimentacaoBuilder Id(Long id) {
            this.id = id;
            return this;
        }

        public MovimentacaoBuilder Tipo(Long tipo) {
            this.tipo = tipo;
            return this;
        }

        public MovimentacaoBuilder Quantidade(Long quantidade) {
            this.quantidade = quantidade;
            return this;
        }

        public MovimentacaoBuilder DataMovimentacao(Date dataMovimentacao) {
            this.dataMovimentacao = dataMovimentacao;
            return this;
        }

        public MovimentacaoBuilder PessoaOrigem(Pessoa pessoaOrigem) {
            this.pessoaOrigem = pessoaOrigem;
            return this;
        }

        public MovimentacaoBuilder PessoaDestino(Pessoa pessoaDestino) {
            this.pessoaDestino = pessoaDestino;
            return this;
        }

        public MovimentacaoBuilder Produto(Produto produto) {
            this.produto = produto;
            return this;
        }

        public Movimentacao build() {
            checkNotNull(this.tipo, "Tipo é obrigatório");
            checkNotNull(this.quantidade, "Quantidade é obrigatório");
            checkNotNull(this.dataMovimentacao, "Data de movimento é obrigatório");
            checkNotNull(this.pessoaOrigem, "Pessoa Origem é obrigatório");
            checkNotNull(this.pessoaDestino, "Pessoa Destino é obrigatório");
            checkNotNull(this.produto, "Produto é obrigatório");

            Movimentacao movimentacao = new Movimentacao();

            movimentacao.setTipo(this.tipo);
            movimentacao.setExtornado(false);
            movimentacao.setQuantidade(this.quantidade);
            movimentacao.setDataMovimentacao(this.dataMovimentacao);
            movimentacao.setPessoaOrigem(this.pessoaOrigem);
            movimentacao.setPessoaDestino(this.pessoaDestino);
            movimentacao.setProduto(this.produto);

            if (this.id != null) {
                movimentacao.id = this.id;
            }

            return movimentacao;
        }
    }
}
