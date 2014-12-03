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
    @JoinColumn(name = "id_referencia")
    private Pessoa referencia;

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

    public Pessoa getReferencia() {
        return referencia;
    }

    public void setReferencia(Pessoa referencia) {
        this.referencia = referencia;
    }

    public static MovimentacaoBuilder builder() {
        return new MovimentacaoBuilder();
    }

    public static class MovimentacaoBuilder {

        private Long id;
        private Long tipo;
        private Long quantidade;
        private Date dataMovimentacao;
        private Pessoa referencia;
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

        public MovimentacaoBuilder Referencia(Pessoa referencia) {
            this.referencia = referencia;
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
            checkNotNull(this.referencia, "Referencia é obrigatório");
            checkNotNull(this.produto, "Produto é obrigatório");

            Movimentacao movimentacao = new Movimentacao();

            movimentacao.setTipo(this.tipo);
            movimentacao.setExtornado(false);
            movimentacao.setQuantidade(this.quantidade);
            movimentacao.setDataMovimentacao(this.dataMovimentacao);
            movimentacao.setReferencia(this.referencia);
            movimentacao.setProduto(this.produto);

            if (this.id != null) {
                movimentacao.id = this.id;
            }

            return movimentacao;
        }
    }
}
