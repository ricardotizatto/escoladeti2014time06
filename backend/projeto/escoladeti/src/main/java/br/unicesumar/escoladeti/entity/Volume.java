package br.unicesumar.escoladeti.entity;

import javax.persistence.*;

import br.unicesumar.escoladeti.enums.VolumeStatus;

import java.util.Date;
import java.util.Objects;

@Entity
public class Volume  {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_responsavel")
    private Usuario responsavel;

    @Column(name = "pagina_inicio")
    private Integer paginaInicio;

    @Column(name = "pagina_fim")
    private Integer paginaFim;

    @Enumerated(EnumType.STRING)
    private VolumeStatus status;

    @Column(name = "id_solicitacao_item")
    private Long idSolicitacaoItem;

    @ManyToOne
    @JoinColumn(name = "id_responsavelrevisao")
    private Usuario responsavelRevisao;

    private String observacao;

    @Column(name = "data_impressao")
    private Date dataImpressao;

    @Column(name = "data_revisao")
    private Date dataRevisao;

    @Column(name = "data_enviado")
    private Date dataEnviado;

    public Usuario getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Usuario responsavel) {
        this.responsavel = responsavel;
    }

    public Integer getPaginaInicio() {
        return paginaInicio;
    }

    public void setPaginaInicio(Integer paginaInicio) {
        this.paginaInicio = paginaInicio;
    }

    public Integer getPaginaFim() {
        return paginaFim;
    }

    public void setPaginaFim(Integer paginaFim) {
        this.paginaFim = paginaFim;
    }

    public VolumeStatus getStatus() {
        return status;
    }

    public void setStatus(VolumeStatus status) {
        this.status = status;
    }

    public Long getIdSolicitacaoItem() {
        return idSolicitacaoItem;
    }

    public void setIdSolicitacaoItem(Long idSolicitacaoItem) {
        this.idSolicitacaoItem = idSolicitacaoItem;
    }

    public Usuario getResponsavelRevisao() {
        return responsavelRevisao;
    }

    public void setResponsavelRevisao(Usuario responsavelRevisao) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void rejeitar() {
        setStatus(VolumeStatus.REJEITADO);
        this.dataImpressao = null;
    }

}
