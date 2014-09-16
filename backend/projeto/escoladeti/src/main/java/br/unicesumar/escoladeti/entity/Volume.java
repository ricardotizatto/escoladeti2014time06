package br.unicesumar.escoladeti.entity;

import javax.persistence.*;

import org.hibernate.validator.constraints.NotEmpty;

import br.unicesumar.escoladeti.enums.OrdemProducaoStatus;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.Date;

@Entity
public class Volume extends Entidade {

    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "id_responsavel")
    private PessoaFisica responsavel;

    private Long paginaInicio;

    private Long paginaFim;

    @Enumerated(EnumType.STRING)
    private OrdemProducaoStatus status;

    @JoinColumn(name = "id_solicitacao_item", referencedColumnName = "id")
    private Long idItemSolicitacao;

    @ManyToOne
    @JoinColumn(name = "id_responsavelrevisao")
    private PessoaFisica responsavelRevisao;

    private String observacao;

    @Column(name = "data_impressao")
    private Date dataImpressao;

    @Column(name = "data_revisao")
    private Date dataRevisao;

    @Column(name = "data_enviado")
    private Date dataEnviado;

    public PessoaFisica getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(PessoaFisica responsavel) {
        this.responsavel = responsavel;
    }

    public Long getPaginaInicio() {
        return paginaInicio;
    }

    public void setPaginaInicio(Long paginaInicio) {
        this.paginaInicio = paginaInicio;
    }

    public Long getPaginaFim() {
        return paginaFim;
    }

    public void setPaginaFim(Long paginaFim) {
        this.paginaFim = paginaFim;
    }

    public OrdemProducaoStatus getStatus() {
        return status;
    }

    public void setStatus(OrdemProducaoStatus status) {
        this.status = status;
    }

    public Long getIdItemSolicitacao() {
        return idItemSolicitacao;
    }

    public void setIdItemSolicitacao(Long idItemSolicitacao) {
        this.idItemSolicitacao = idItemSolicitacao;
    }

    public PessoaFisica getResponsavelRevisao() {
        return responsavelRevisao;
    }

    public void setResponsavelRevisao(PessoaFisica responsavelRevisao) {
        this.responsavelRevisao = responsavelRevisao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Date getDataImpressao() {
        return dataImpressao;
    }

    public void setDataImpressao(Date dataImpressao) {
        this.dataImpressao = dataImpressao;
    }

    public Date getDataRevisao() {
        return dataRevisao;
    }

    public void setDataRevisao(Date dataRevisao) {
        this.dataRevisao = dataRevisao;
    }

    public Date getDataEnviado() {
        return dataEnviado;
    }

    public void setDataEnviado(Date dataEnviado) {
        this.dataEnviado = dataEnviado;
    }
}
