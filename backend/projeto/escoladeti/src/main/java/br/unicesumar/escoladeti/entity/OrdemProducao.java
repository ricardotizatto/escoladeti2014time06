package br.unicesumar.escoladeti.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
        
@Entity
public class OrdemProducao extends Entidade {
    
    @NotEmpty
    @NotNull
    private String status;
    
    @OneToMany
    private List<ParteMaterial> partes;

    public OrdemProducao(String status, List<ParteMaterial> partes) {
        this.status = status;
        this.partes = partes;
    }

    public OrdemProducao() {
    }

    public OrdemProducao(Long id,String status, List<ParteMaterial> partes) {
        this.id = id;
        this.status = status;
        this.partes = partes;
    }
    

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ParteMaterial> getPartes() {
        return partes;
    }

    public void setPartes(List<ParteMaterial> partes) {
        this.partes = partes;
    }
    
}
