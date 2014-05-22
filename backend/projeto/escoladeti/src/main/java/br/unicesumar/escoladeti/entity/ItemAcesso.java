package br.unicesumar.escoladeti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class ItemAcesso extends Entidade {
    
    @NotNull
    @NotEmpty
    private String nomeComponente;

    public ItemAcesso() {

    }

    public ItemAcesso(String nomeComponente) {
        this.nomeComponente = nomeComponente;
    }

    public String getNomeComponente() {
        return nomeComponente;
    }

    public void setNomeComponente(String nomeComponente) {
        this.nomeComponente = nomeComponente;
    }
}
