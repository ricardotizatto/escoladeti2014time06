package br.unicesumar.escoladeti.comando;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotNull;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private String data;

    private Long revisor;

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

    public SimpleDateFormat getSimpleDateFormat() {
        return simpleDateFormat;
    }

    public void setSimpleDateFormat(SimpleDateFormat simpleDateFormat) {
        this.simpleDateFormat = simpleDateFormat;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Long getRevisor() {
        return revisor;
    }

    public void setRevisor(Long revisor) {
        this.revisor = revisor;
    }

    public Date getDataAsDate() {
        try {
            return data == null ? null : simpleDateFormat.parse(data);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException("Data inválida");
        }
    }
}
