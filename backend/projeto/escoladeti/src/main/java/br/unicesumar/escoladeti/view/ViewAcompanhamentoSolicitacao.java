package br.unicesumar.escoladeti.view;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;

@Entity(name = "viewAcompanhamentoSolicitacao")
public class ViewAcompanhamentoSolicitacao implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_SOLICITACAO")
    private Long solicitacaoId;
    
    private String status;
    
    @Column(name="datachegada")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataChegada;
    
    @Column(name = "traducaomaterial")
    private String traducaoMaterial;
    
    private String responsavel;
    
    private String revisor;
    
    private String material;

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

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }


    public String getRevisor() {
        return revisor;
    }

    public void setRevisor(String revisor) {
        this.revisor = revisor;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
    
        
    
}
