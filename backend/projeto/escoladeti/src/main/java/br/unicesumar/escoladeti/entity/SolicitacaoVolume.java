package br.unicesumar.escoladeti.entity;

import br.unicesumar.escoladeti.enums.VolumeStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * Created by Jhonatan on 22/10/2014.
 */
@Entity
public class SolicitacaoVolume extends Entidade {

    @Column(name = "data_envio")
    private Date dataEnvio;

    @OneToOne
    @JoinColumn(name = "id_volume")
    private Volume volume;

    @ManyToOne
    @JoinColumn(name = "id_solicitacaoitem", insertable = false, updatable = false)
    @JsonIgnore
    private SolicitacaoItem solicitacaoItem;

    @Column(name = "id_solicitacaoitem")
    private Long idSolicitacaoItem;

    public void marcarComoEnviado(Date data) {
        if (!volume.getStatus().equals(VolumeStatus.REVISADO)) {
            throw new RuntimeException("Sómente volume revisado pode ser marcado como enviado.");
        }

        if (data == null) {
            throw new RuntimeException("Informe data de envio.");
        }

        if (data.after(new Date())) {
            throw new RuntimeException("Data deve ser menor ou igual a hoje.");
        }

        if (data.before(volume.getDataRevisao())) {
            throw new RuntimeException("Data de Envio deve ser maior ou igual a data de revisão do volume");
        }

        setDataEnvio(data);
    }

    public Date getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(Date dataEnvio) {
        this.dataEnvio = dataEnvio;
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

    public Long getIdSolicitacaoItem() {
        return idSolicitacaoItem;
    }

    public void setIdSolicitacaoItem(Long idSolicitacaoItem) {
        this.idSolicitacaoItem = idSolicitacaoItem;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof SolicitacaoVolume)) {
            return false;
        }

        SolicitacaoVolume solicitacaoVolume = (SolicitacaoVolume) obj;

        return solicitacaoVolume == this || solicitacaoVolume.id.equals(this.id);
    }

    public boolean estaEnviado() {
        return dataEnvio != null;
    }
}
