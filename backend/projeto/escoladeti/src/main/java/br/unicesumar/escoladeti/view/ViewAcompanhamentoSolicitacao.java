package br.unicesumar.escoladeti.view;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity(name = "viewAcompanhamentoSolicitacao")
public class ViewAcompanhamentoSolicitacao implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    private Long solicitacaoId;
    
    private String status;
    
    @Column(name="datachegada")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataChegada;
    
    @Column(name = "traducaomaterial")
    private String traducaoMaterial;
    
    private String responsavel;
    
    private String material;
    
    @Column(name = "outratraducao")
    private String outraTraducao;

    public ViewAcompanhamentoSolicitacao() {
    }
    
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

    public void setDataChegada(Date datachegada) {
        this.dataChegada = datachegada;
    }
    
    public String getTraducaoMaterial() {
        return traducaoMaterial;
    }

    public void setTraducaoMaterial(String traducaoMaterial) {
        this.traducaoMaterial = traducaoMaterial;
    }
    
    public String getOutraTraducao() {
        return outraTraducao;
    }

    public void setOutraTraducao(String outraTraducao) {
        this.outraTraducao = outraTraducao;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
