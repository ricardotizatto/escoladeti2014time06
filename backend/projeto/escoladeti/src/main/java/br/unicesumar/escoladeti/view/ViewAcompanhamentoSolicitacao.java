package br.unicesumar.escoladeti.view;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;

@Entity(name = "viewAcompanhamentoSolicitacao")
public class ViewAcompanhamentoSolicitacao implements Serializable{
    
    @Id
    @Column(name = "ID_SOLICITACAO")
    private Long solicitacaoId;
    
    @Column(name = "status_item")
    private String itemStatus;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date datachegada;
    
    @Column(name = "traducaomaterial")
    private String traducaoMaterial;
    
    private String responsavel;
    
    @Column(name = "id_ordem")
    private Long ordemId;
    
    private String revisor;
    
    @Column(name = "nomematerial")
    private String nomeMaterial;

    public ViewAcompanhamentoSolicitacao() {
    }
    
    public Long getSolicitacaoId() {
        return solicitacaoId;
    }

    public void setSolicitacaoId(Long solicitacaoId) {
        this.solicitacaoId = solicitacaoId;
    }

    public String getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(String itemStatus) {
        this.itemStatus = itemStatus;
    }

    public Date getDatachegada() {
        return datachegada;
    }

    public void setDatachegada(Date datachegada) {
        this.datachegada = datachegada;
    }

    public String getTraducaoMaterial() {
        return traducaoMaterial;
    }

    public void setTraducaoMaterial(String traducaoMaterial) {
        this.traducaoMaterial = traducaoMaterial;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public Long getOrdemId() {
        return ordemId;
    }

    public void setOrdemId(Long ordemId) {
        this.ordemId = ordemId;
    }

    public String getRevisor() {
        return revisor;
    }

    public void setRevisor(String revisor) {
        this.revisor = revisor;
    }

    public String getNomeMaterial() {
        return nomeMaterial;
    }

    public void setNomeMaterial(String nomeMaterial) {
        this.nomeMaterial = nomeMaterial;
    }
    
        
    
}
