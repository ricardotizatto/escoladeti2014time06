package br.unicesumar.escoladeti.entity;

import br.unicesumar.escoladeti.comando.ComandoAlterarData;
import br.unicesumar.escoladeti.enums.SolicitacaoVolumeStatus;
import br.unicesumar.escoladeti.enums.VolumeStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * Created by Jhonatan on 22/10/2014.
 */
@Entity
public class SolicitacaoVolume {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "data_envio")
    private Date dataEnvio;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_impressao")
    private Date dataImpressao;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_revisao")
    private Date dataRevisao;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private SolicitacaoVolumeStatus status;

    @OneToOne
    @JoinColumn(name = "id_volume", insertable = false, updatable = false)
    private Volume volume;


    @Column(name = "id_volume")
    private Long idVolume;

    @ManyToOne
    @JoinColumn(name = "id_responsavelrevisao", insertable = false, updatable = false)
    private Usuario responsavelRevisao;

    @Column(name = "id_responsavelrevisao")
    private Long idResponsavelRevisao;

    @ManyToOne
    @JoinColumn(name = "id_responsavel", insertable = false, updatable = false)
    private Usuario responsavel;

    @Column(name = "id_responsavel")
    private Long idResponsavel;

    @ManyToOne
    @JoinColumn(name = "id_responsavelimpressao", insertable = false, updatable = false)
    private Usuario responsavelImpressao;

    @Column(name = "id_responsavelimpressao")
    private Long idResponsavelImpressao;

    @ManyToOne
    @JoinColumn(name = "id_responsavelenvio", insertable = false, updatable = false)
    private Usuario responsavelEnvio;

    @Column(name = "id_responsavelenvio")
    private Long idResponsavelEnvio;

    @ManyToOne
    @JoinColumn(name = "id_solicitacaoitem", insertable = false, updatable = false)
    @JsonIgnore
    private SolicitacaoItem solicitacaoItem;

    @Column(name = "id_solicitacaoitem")
    private Long idSolicitacaoItem;

    private String observacao;

    public void marcarComoEnviado(ComandoAlterarData comando) {
        if (comando.getUsuario() == null ) {
            throw new RuntimeException("Informe o reponsável pelo envio");
        }

        if (!getStatus().equals(SolicitacaoVolumeStatus.REVISADO)) {
            throw new RuntimeException("Sómente volume revisado pode ser marcado como enviado.");
        }

        if (comando.getData() == null) {
            throw new RuntimeException("Informe data de envio.");
        }

        if (comando.getDataAsDate().after(new Date())) {
            throw new RuntimeException("Data deve ser menor ou igual a hoje.");
        }

        if (comando.getDataAsDate().before(getDataRevisao())) {
            throw new RuntimeException("Data de Envio deve ser maior ou igual a data de revisão.");
        }

        setIdResponsavelEnvio(comando.getUsuario());
        setDataEnvio(comando.getDataAsDate());
        setStatus(SolicitacaoVolumeStatus.ENVIADO);
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
        return status.equals(SolicitacaoVolumeStatus.ENVIADO);
    }

    public Date getDataImpressao() {
        return dataImpressao;
    }

    public void setDataImpressao(Date dataImpressao) {
        this.dataImpressao = dataImpressao;
    }

    public Date getDataRevisao() {
        return dataRevisao;
    }

    public void setDataRevisao(Date dataRevisao) {
        this.dataRevisao = dataRevisao;
    }


    public void rejeitar(ComandoAlterarData comandoAlterarData) {
        if (comandoAlterarData.getDataAsDate() == null) {
            throw  new RuntimeException("Data da rejeição deve ser informada.");
        }

        if (comandoAlterarData.getUsuario() == null) {
            throw  new RuntimeException("Revisor deve ser informado.");
        }

        if (this.dataImpressao != null && comandoAlterarData.getDataAsDate().before(this.dataImpressao)) {
            throw  new RuntimeException("Data de rejeição deve ser maior ou igual a data de impressão.");
        }

        if (comandoAlterarData.getDataAsDate().after(new Date())) {
            throw  new RuntimeException("Data da rejeição deve ser menor ou igual a hoje.");
        }

        if (!this.getStatus().equals(SolicitacaoVolumeStatus.ANDAMENTO) && !this.getStatus().equals(SolicitacaoVolumeStatus.IMPRESSO)) {
            throw new RuntimeException("Sómente volume em andamento ou impresso  pode ser marcado como rejeitado.");
        }

        setStatus(SolicitacaoVolumeStatus.REJEITADO);
        setIdResponsavelRevisao(comandoAlterarData.getUsuario());
        setDataRevisao(comandoAlterarData.getDataAsDate());
    }


    public void marcarComoRevisado(ComandoAlterarData comando) {
        if(!volume.getStatus().equals(VolumeStatus.CONCLUIDO)) {
            throw new RuntimeException("Volume deve estar concluido para ser marcado como revisado.");
        }

        if (comando.getUsuario() == null) {
            throw new RuntimeException("Informe um revisor.");
        }

        if (comando.getDataAsDate() == null) {
            throw new RuntimeException("Informe data da revisão");
        }

        if (!getStatus().equals(SolicitacaoVolumeStatus.ANDAMENTO) && !getStatus().equals(SolicitacaoVolumeStatus.IMPRESSO)) {
            throw new RuntimeException("Sómente volume em Amdamento ou Impresso pode ser marcado como revisado.");
        }

        if (dataImpressao != null && comando.getDataAsDate().before(this.dataImpressao)) {
            throw  new RuntimeException("Data de revisão deve ser maior ou igual a data de impressão.");
        }

        if (comando.getDataAsDate().after(new Date())) {
            throw new RuntimeException("Data de revisão deve ser menor ou igual a hoje.");
        }

        setDataRevisao(comando.getDataAsDate());
        setIdResponsavelRevisao(comando.getUsuario());
        setStatus(SolicitacaoVolumeStatus.REVISADO);
    }


    public void marcarComoImpresso(ComandoAlterarData comando) {

        if (comando.getUsuario() == null ) {
            throw new RuntimeException("Inmforme o reponsável pela impressão");
        }

        if (!volume.getStatus().equals(VolumeStatus.CONCLUIDO)) {
            throw new RuntimeException("volume deve estar Concluido para ser marcado como impresso.");
        }

        if (comando.getDataAsDate() == null) {
            throw new RuntimeException("Informe data de impressão");
        }

        if (comando.getDataAsDate().after(new Date())) {
            throw new RuntimeException("Data da impressão deve ser menor ou igual a data atual.");
        }

        setIdResponsavelImpressao(comando.getUsuario());
        setDataImpressao(comando.getDataAsDate());
        setStatus(SolicitacaoVolumeStatus.IMPRESSO);
    }





    public SolicitacaoVolumeStatus getStatus() {
        return status;
    }

    public void setStatus(SolicitacaoVolumeStatus status) {
        this.status = status;
    }

    public Usuario getResponsavelRevisao() {
        return responsavelRevisao;
    }

    public void setResponsavelRevisao(Usuario responsavelRevisao) {
        this.responsavelRevisao = responsavelRevisao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Long getIdVolume() {
        return idVolume;
    }

    public void setIdVolume(Long idVolume) {
        this.idVolume = idVolume;
    }

    public Usuario getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Usuario responsavel) {
        this.responsavel = responsavel;
    }

    public Long getIdResponsavel() {
        return idResponsavel;
    }

    public void setIdResponsavel(Long idResponsavel) {
        this.idResponsavel = idResponsavel;
    }

    public Usuario getResponsavelImpressao() {
        return responsavelImpressao;
    }

    public void setResponsavelImpressao(Usuario responsavelImpressao) {
        this.responsavelImpressao = responsavelImpressao;
    }

    public Long getIdResponsavelImpressao() {
        return idResponsavelImpressao;
    }

    public void setIdResponsavelImpressao(Long idResponsavelImpressao) {
        this.idResponsavelImpressao = idResponsavelImpressao;
    }

    public Usuario getResponsavelEnvio() {
        return responsavelEnvio;
    }

    public void setResponsavelEnvio(Usuario responsavelEnvio) {
        this.responsavelEnvio = responsavelEnvio;
    }

    public Long getIdResponsavelEnvio() {
        return idResponsavelEnvio;
    }

    public void setIdResponsavelEnvio(Long idResponsavelEnvio) {
        this.idResponsavelEnvio = idResponsavelEnvio;
    }

    public Long getIdResponsavelRevisao() {
        return idResponsavelRevisao;
    }

    public void setIdResponsavelRevisao(Long idResponsavelRevisao) {
        this.idResponsavelRevisao = idResponsavelRevisao;
    }

    public void retivar() {
        if (estaEnviado()) {
            throw new RuntimeException("Esta ordem já foi enviada e não pode ser reativada");
        }
        this.dataImpressao = null;
        this.dataRevisao = null;
        this.idResponsavelImpressao = null;
        this.idResponsavelRevisao = null;
        setStatus(SolicitacaoVolumeStatus.ANDAMENTO);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
