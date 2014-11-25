package br.unicesumar.escoladeti.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class PerfilItemAcesso extends Entidade{
    
    @OneToOne
    @JoinColumn(name = "id_perfilacesso")
    private PerfilAcesso perfilAcesso;
    
    @OneToOne
    @JoinColumn(name = "id_itemacesso")
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
