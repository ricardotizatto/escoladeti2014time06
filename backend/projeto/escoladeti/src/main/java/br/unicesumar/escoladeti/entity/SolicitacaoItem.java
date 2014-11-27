package br.unicesumar.escoladeti.entity;

import br.unicesumar.escoladeti.enums.StatusItem;
import br.unicesumar.escoladeti.enums.Transcricao;
import br.unicesumar.escoladeti.enums.VolumeStatus;
import br.unicesumar.escoladeti.repository.VolumeRepository;
import br.unicesumar.escoladeti.view.ViewAcompanhamentoSolicitacao;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Entity
public class SolicitacaoItem extends Entidade{
    private static final long serialVersionUID = 1L;

    private String outro;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Transcricao traducaoMaterial;

    @ManyToOne
    @JoinColumn(name="id_material")
    private Livro livro;

    @ManyToOne
    @JoinColumn(name="id_solicitacao", referencedColumnName = "id")
    @JsonIgnore
    private Solicitacao solicitacao;

    @Enumerated(EnumType.STRING)
    private StatusItem status;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "solicitacaoItem")
    private Set<SolicitacaoVolume> solicitacaoVolumes;

    private SolicitacaoItem(Long id) {
        this.id = id;
    }

    public SolicitacaoItem() {
    }

    public Solicitacao getSolicitacao() {
        return solicitacao;
    }

    public Transcricao getTraducaoMaterial() {
        return traducaoMaterial;
    }

    public void setTraducaoMaterial(Transcricao traducaoMaterial) {
        this.traducaoMaterial = traducaoMaterial;
    }

    public void setSolicitacao(Solicitacao solicitacao) {
        this.solicitacao = solicitacao;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public String getOutro() {
        return outro;
    }

    public void setOutro(String outro) {
        this.outro = outro;
    }

    public void setStatus(StatusItem status) {
        this.status = status;
    }

    public StatusItem getStatus() {
        return status;
    }



    public Long getNumeroSolicitacao() {
        return this.solicitacao.getId();
    }

    public static SolicitacaoItem criar(Long id) {
        return new SolicitacaoItem(id);
    }

    public void cancelar() {

        for (SolicitacaoVolume solicitacaoVolume : solicitacaoVolumes) {
            if (solicitacaoVolume.getDataEnvio() != null) {
                throw new RuntimeException("Item da solicitação possui volume enviado e não pode ser Cancelado.<br> Este Item pode ser finalizado");
            }
        }

        this.setStatus(StatusItem.CANCELADO);
    }


//    public void validarPaginas(Integer paginaInicio, Integer paginafinal) {
//
//        for (SolicitacaoVolume solicitacaoVolume : solicitacaoVolumes) {
//            Volume volume = solicitacaoVolume.getVolume();
//            if (paginaInicio >= volume.getPaginaInicio()  && paginaInicio <=volume.getPaginaFim()
//                    || paginafinal >= volume.getPaginaInicio() && paginafinal <= volume.getPaginaFim()) {
//                throw new RuntimeException(
//                        String.format("Página inicial ou final esta dentro do intervalo %d a %d . Volume: %d.<br>" +
//                                " Insira paginás que não estejam nesse intervalo.", volume.getPaginaInicio(), volume.getPaginaFim(), volume.getId()));
//            }
//        }
//
//    }

    public Integer getMaiorPagina() {
        Integer maior = 0;

        for (SolicitacaoVolume solicitacaoVolume : solicitacaoVolumes) {
            Volume volume = solicitacaoVolume.getVolume();
            if (volume.getPaginaFim() > maior) {
                maior = volume.getPaginaFim();
            }
        }

        return maior;
    }

    public boolean possuiSolicitavaoVolumes() {
        return getSolicitacaoVolumes().size() > 0;
    }

    public SolicitacaoVolume gerarSolicitacaoVolume(Volume volume) {
        SolicitacaoVolume solicitacaoVolume = new SolicitacaoVolume();
        solicitacaoVolume.setVolume(volume);
        solicitacaoVolume.setIdSolicitacaoItem(getId());
        return solicitacaoVolume;
    }

    public static class SolicitacaoItemBuilder {
        private Livro livro;
        private String status;
        private String traducaoMaterial;
        private String outro;
        private Long id;
        private Solicitacao solicitacao;

        public SolicitacaoItem.SolicitacaoItemBuilder livro(Livro livro) {
            this.livro = livro;
            return this;
        }

        public SolicitacaoItem.SolicitacaoItemBuilder status(String status) {
            this.status = status;
            return this;
        }

        public SolicitacaoItem.SolicitacaoItemBuilder traducaoMaterial(String traducaoMaterial) {
            this.traducaoMaterial = traducaoMaterial;
            return this;
        }

        public SolicitacaoItem.SolicitacaoItemBuilder outro(String outro) {
            this.outro = outro;
            return this;
        }

        public SolicitacaoItem build() {
            SolicitacaoItem solicitacaoItem = new SolicitacaoItem();
            solicitacaoItem.setLivro(livro);
            solicitacaoItem.setTraducaoMaterial(Transcricao.of(this.traducaoMaterial));
            solicitacaoItem.setOutro(this.outro);
            solicitacaoItem.setId(this.id);
            solicitacaoItem.setSolicitacao(this.solicitacao);
            solicitacaoItem.setStatus(StatusItem.of(this.status));

            if(solicitacaoItem.getTraducaoMaterial().equals(Transcricao.OUTRO)
                    && (solicitacaoItem.getOutro() == null || solicitacaoItem.getOutro().isEmpty() ) ) {
                throw new RuntimeException("Para tradução do material do tipo 'OUTRO'"
                        + " é obrigatório informar o campo 'OUTRO' ");
            }

            return solicitacaoItem;
        }

        public SolicitacaoItemBuilder status(StatusItem status) {
            this.status = status.name();
            return this;
        }

        public SolicitacaoItemBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public SolicitacaoItemBuilder solicitacao(Solicitacao solicitacao) {
            this.solicitacao = solicitacao;
            return this;
        }
    }

    public static SolicitacaoItemBuilder builder() {
        return new SolicitacaoItemBuilder();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof  SolicitacaoItem)) {
            return false;
        }

        SolicitacaoItem outroItem = (SolicitacaoItem) obj;

        return id.equals(outroItem.id)
                || outroItem.livro.equals(this.livro)
                && outroItem.traducaoMaterial.equals(this.traducaoMaterial)
                && !outroItem.traducaoMaterial.equals(Transcricao.OUTRO);
    }

    public ViewAcompanhamentoSolicitacao montarItemAcompanhamento() {
        ViewAcompanhamentoSolicitacao acompanhamentoSolicitacao = new ViewAcompanhamentoSolicitacao();
        acompanhamentoSolicitacao.setId(this.getId());
        acompanhamentoSolicitacao.setDataChegada(this.getSolicitacao().getDataChegada());
        acompanhamentoSolicitacao.setMaterial(this.getLivro().getNome());
        acompanhamentoSolicitacao.setOutraTraducao(this.getOutro());
        acompanhamentoSolicitacao.setResponsavel(this.getSolicitacao().getResponsavel().getNomeCompleto());
        acompanhamentoSolicitacao.setStatus(this.getStatus().name());
        acompanhamentoSolicitacao.setSolicitacaoId(this.getSolicitacao().getId());
        acompanhamentoSolicitacao.setTraducaoMaterial(this.getTraducaoMaterial().name());

        return acompanhamentoSolicitacao;
    }

    public void finalizar() {
        if (solicitacaoVolumes.size() == 0) {
            throw new RuntimeException("Só é possível finalizar ordem com volumes.");
        }

        Short quantidadeEnviado = 0;
        for (SolicitacaoVolume solicitacaoVolume : solicitacaoVolumes) {
            if (solicitacaoVolume.estaEnviado()) {
                quantidadeEnviado++;
                break;
            }
        }

        if (quantidadeEnviado <= 0) {
            throw new RuntimeException("É nescessário ter ao menos um volume enviado para finalizar este item");
        }

        setStatus(StatusItem.FINALIZADO);
    }

    public Set<SolicitacaoVolume> getSolicitacaoVolumes() {
        return solicitacaoVolumes;
    }

    public void setSolicitacaoVolumes(Set<SolicitacaoVolume> solicitacaoVolumes) {
        this.solicitacaoVolumes = solicitacaoVolumes;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
