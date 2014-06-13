package br.unicesumar.escoladeti.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import br.unicesumar.escoladeti.enums.OrdemProducaoStatus;
        
@Entity
public class OrdemProducao extends Entidade {
    private static final long serialVersionUID = 1L;
	
    @NotNull
    @ManyToOne
    private SolicitacaoItem solicitacaoItem;
    
    @NotNull
    @Enumerated(EnumType.STRING)
    private OrdemProducaoStatus status;
    
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="ordemProducao")
    private List<ParteMaterial> partes;

    public OrdemProducao(OrdemProducaoStatus status) {
        this.status = status;
    }

    public OrdemProducao() {
    }

    public OrdemProducao(Long id,OrdemProducaoStatus status) {
        this.id = id;
        this.status = status;
    }
    
    
    public OrdemProducaoStatus getStatus() {
        return status;
    }

    public SolicitacaoItem getSolicitacaoItem() {
		return solicitacaoItem;
	}
    
    public List<ParteMaterial> getPartes() {
		return partes;
	}
    
}
