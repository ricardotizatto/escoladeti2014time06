package br.unicesumar.escoladeti.comando;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotNull;

/**
 * Created by Jhonatan on 16/09/2014.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ComandoSalvarVolume {
    @NotNull(message = "Responsável é obrigatório")
    private Long responsavel;

    @NotNull(message =  "Deve ser informado a página inicial")
    private Integer paginaInicio;

    @NotNull(message =  "Deve ser informado a página final")
    private Integer paginaFim;

    private String observacao;

    @NotNull(message = "SolicitacaoItem deve possuir valor")
    private Long idSolicitacaoItem;

    public Long getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Long responsavel) {
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

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Long getIdSolicitacaoItem() {
        return idSolicitacaoItem;
    }

    public void setIdSolicitacaoItem(Long idSolicitacaoItem) {
        this.idSolicitacaoItem = idSolicitacaoItem;
    }
}
