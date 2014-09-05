package br.unicesumar.escoladeti.entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class PerfilItemAcesso extends Entidade{
    
    @OneToOne
    private PerfilAcesso perfilAcesso;
    
    @OneToOne
    private ItemAcesso itemAcesso;

    public PerfilItemAcesso() {
    }

    public PerfilAcesso getPerfilAcesso() {
        return perfilAcesso;
    }

    public void setPerfilAcesso(PerfilAcesso perfilAcesso) {
        this.perfilAcesso = perfilAcesso;
    }

    public ItemAcesso getItemAcesso() {
        return itemAcesso;
    }

    public void setItemAcesso(ItemAcesso itemAcesso) {
        this.itemAcesso = itemAcesso;
    }
    
}
