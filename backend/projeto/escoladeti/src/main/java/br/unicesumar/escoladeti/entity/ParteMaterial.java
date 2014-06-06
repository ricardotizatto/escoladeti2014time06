package br.unicesumar.escoladeti.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotEmpty;

import br.unicesumar.escoladeti.common.OrdemProducaoStatus;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class ParteMaterial extends Entidade {

    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "id_responsavel")
    private PessoaFisica responsavel;

    private Long paginaInicio;

    private Long paginaFim;

    @NotEmpty
    @Enumerated(EnumType.STRING)
    private OrdemProducaoStatus status;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "id_ordemproducao", referencedColumnName = "id")
    private OrdemProducao ordemProducao;

    @ManyToOne
    @JoinColumn(name = "id_responsavelrevisao")
    private PessoaFisica responsavelRevisao;

    private String observacao;

    private byte[] arquivo;

    public ParteMaterial() {
    }

    public PessoaFisica getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(PessoaFisica responsavel) {
        this.responsavel = responsavel;
    }

    public Long getPaginaInicio() {
        return paginaInicio;
    }

    public void setPaginaInicio(Long paginaInicio) {
        this.paginaInicio = paginaInicio;
    }

    public Long getPaginaFim() {
        return paginaFim;
    }

    public void setPaginaFim(Long paginaFim) {
        this.paginaFim = paginaFim;
    }

    public OrdemProducaoStatus getStatus() {
        return status;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public byte[] getArquivo() {
        return arquivo;
    }

    public void setArquivo(byte[] arquivo) {
        this.arquivo = arquivo;
    }
}
