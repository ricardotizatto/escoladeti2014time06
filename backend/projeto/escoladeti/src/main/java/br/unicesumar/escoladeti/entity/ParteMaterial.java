package br.unicesumar.escoladeti.entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class ParteMaterial extends Entidade {
    
    @OneToOne
    private PessoaFisica responsavel;
    
    private Long paginaInicio;
    
    private Long paginaFim;
    
    private String status;
    
    @OneToOne
    private PessoaFisica revisao;
    
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public PessoaFisica getRevisao() {
        return revisao;
    }

    public void setRevisao(PessoaFisica revisao) {
        this.revisao = revisao;
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
