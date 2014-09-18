package br.unicesumar.escoladeti.pesquisa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PesquisaSolicitacao {
    
    private String status;
    private Date dataInicio;
    private Date dataFim;
    private Long solicitacaoId;
    private Long ordemId;
    private String material;
    private String responsavel;
    private String revisor;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if (status != null) {
            this.status = status.toUpperCase();
        }
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        if(dataFim != null && dataInicio.after(dataFim)){
            this.dataInicio = dataInicio;
        }else if(dataInicio != null){
            throw new RuntimeException("Data de Inicio não pode ser maior que Final"); 
        } 
        
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        if (dataInicio != null && dataFim.before(dataInicio)) {
            this.dataFim = dataFim;
        }else if(dataFim != null){
            throw new RuntimeException("Data Final não pode ser Menos que da Inicio");
        }
    }

    public Long getSolicitacaoId() {
        return solicitacaoId;
    }

    public void setSolicitacaoId(Long solicitacaoId) {
        this.solicitacaoId = solicitacaoId;
    }

    public Long getOrdemId() {
        return ordemId;
    }

    public void setOrdemId(Long ordemId) {
        this.ordemId = ordemId;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        if (material != null) {
            this.material = material.toUpperCase();
        }
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        if(responsavel != null){
            this.responsavel = responsavel.toUpperCase();
        }    
    }

    public String getRevisor() {
        return revisor;
    }

    public void setRevisor(String revisor) {
        if (revisor != null) {
            this.revisor = revisor.toUpperCase();
        }
    }
    
    
}
