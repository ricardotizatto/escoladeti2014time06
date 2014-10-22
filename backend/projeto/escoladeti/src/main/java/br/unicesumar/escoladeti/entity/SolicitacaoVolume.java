package br.unicesumar.escoladeti.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.util.Objects;

/**
 * Created by Jhonatan on 22/10/2014.
 */
@Entity
public class SolicitacaoVolume extends Entidade {

    private Boolean enviado;

    @OneToOne
    @JoinColumn(name = "id_volume")
    private Volume volume;

    @ManyToOne
    @JoinColumn(name = "id_solicitacaoitem")
    private SolicitacaoItem solicitacaoItem;

    public Boolean getEnviado() {
        return enviado;
    }

    public void setEnviado(Boolean enviado) {
        this.enviado = enviado;
    }

    public Volume getVolume() {
        return volume;
    }

    public void setVolume(Volume volume) {
        this.volume = volume;
    }

    public SolicitacaoItem getSolicitacaoItem() {
        return solicitacaoItem;
    }

    public void setSolicitacaoItem(SolicitacaoItem solicitacaoItem) {
        this.solicitacaoItem = solicitacaoItem;
    }


    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
