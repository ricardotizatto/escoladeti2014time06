package br.unicesumar.escoladeti.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.Objects;

@Entity
public class PerfilItemAcesso extends Entidade{
    
    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "id_perfilacesso")
    private PerfilAcesso perfilAcesso;
    
    @OneToOne
    @JoinColumn(name = "id_itemacesso", insertable = false, updatable = false)
    private ItemAcesso itemAcesso;

    @Column(name = "id_itemacesso")
    private Long idItemAcesso;

    public PerfilItemAcesso() {
    }

    public Long getIdItemAcesso() {
        return idItemAcesso;
    }

    public void setIdItemAcesso(Long idItemAcesso) {
        this.idItemAcesso = idItemAcesso;
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


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PerfilItemAcesso) || id == null) {
            return false;
        }

        if (this == o){
            return true;
        }

        PerfilItemAcesso outro = (PerfilItemAcesso) o;

        return id.equals(outro.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
