package br.unicesumar.escoladeti.view;

import br.unicesumar.escoladeti.entity.Entidade;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "viewAcompanhamentoSolicitacao")
public class ViewAcompanhamentoSolicitacao extends Entidade implements Serializable{
    
    @Column(name = "ID_SOLICITACAO")
    private Long solicitacaoId;
    @Column(name = "STATUS_ITEM")
    private String status;
    private Date dataChegada;
    private String traducao;
    private String responsavel;
    private String sobrenomeResponsavel;
    private Long ordemId;
    @Column(name = "NOMEMATERIAL")
    private String material;
    private Date dataEnvio;

    public Long getSolicitacaoId() {
        return solicitacaoId;
    }

    public void setSolicitacaoId(Long solicitacaoId) {
        this.solicitacaoId = solicitacaoId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDataChegada() {
        return dataChegada;
    }

    public void setDataChegada(Date dataChegada) {
        this.dataChegada = dataChegada;
    }

    public String getTraducao() {
        return traducao;
    }

    public void setTraducao(String traducao) {
        this.traducao = traducao;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getSobrenomeResponsavel() {
        return sobrenomeResponsavel;
    }

    public void setSobrenomeResponsavel(String sobrenomeResponsavel) {
        this.sobrenomeResponsavel = sobrenomeResponsavel;
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
        this.material = material;
    }

    public Date getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(Date dataEnvio) {
        this.dataEnvio = dataEnvio;
    }
    
}
