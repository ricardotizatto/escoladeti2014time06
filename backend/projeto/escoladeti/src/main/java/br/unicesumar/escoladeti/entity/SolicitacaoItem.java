package br.unicesumar.escoladeti.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import br.unicesumar.escoladeti.enums.VolumeStatus;
import br.unicesumar.escoladeti.repository.VolumeRepository;
import br.unicesumar.escoladeti.view.ViewAcompanhamentoSolicitacao;
import com.fasterxml.jackson.annotation.JsonIgnore;

import br.unicesumar.escoladeti.enums.StatusItem;
import br.unicesumar.escoladeti.enums.TraducaoMaterial;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class SolicitacaoItem extends Entidade{
    private static final long serialVersionUID = 1L;

    private String outro;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TraducaoMaterial traducaoMaterial;

    @ManyToOne
    @JoinColumn(name="id_material")
    private Livro livro;

    @ManyToOne
    @JoinColumn(name="id_solicitacao", referencedColumnName = "id")
    @JsonIgnore
    private Solicitacao solicitacao;

    @Enumerated(EnumType.STRING)
    private StatusItem status;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_solicitacao_item", insertable = false, updatable = false, referencedColumnName = "id")
    private Set<Volume> volumes = new HashSet<>();

    private SolicitacaoItem(Long id) {
        this.id = id;
    }

    public SolicitacaoItem() {
    }

    public Solicitacao getSolicitacao() {
        return solicitacao;
    }

    public TraducaoMaterial getTraducaoMaterial() {
        return traducaoMaterial;
    }

    public void setTraducaoMaterial(TraducaoMaterial traducaoMaterial) {
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

    public Set<Volume> getVolumes() {
        return volumes;
    }

    public void setVolumes(Set<Volume> volumes) {
        this.volumes = volumes;
    }

    public Long getNumeroSolicitacao() {
        return this.solicitacao.getId();
    }

    public static SolicitacaoItem criar(Long id) {
        return new SolicitacaoItem(id);
    }

    public void cancelar(VolumeRepository volumeRepository) {
        this.setStatus(StatusItem.CANCELADO);

        for (Volume volume : this.volumes) {
            volume.setStatus(VolumeStatus.CANCELADO);
            volumeRepository.save(volume);
        }

    }

    public void validarPaginas(Integer paginaInicio, Integer paginafinal) {
        for (Volume volume : volumes) {
            if (paginaInicio >= volume.getPaginaInicio()  && paginaInicio <=volume.getPaginaFim()
                    || paginafinal >= volume.getPaginaInicio() && paginafinal <= volume.getPaginaFim()) {
                throw new RuntimeException(
                        String.format("Página inicial ou final esta dentro do intervalo %d a %d . Volume: %d.<br>" +
                                " Insira paginás que não estejam nesse intervalo.", volume.getPaginaInicio(), volume.getPaginaFim(), volume.getId()));
            }
        }

    }

    public Integer getMaiorPagina() {
        Integer maior = 0;

        for (Volume volume : volumes) {
            if (volume.getPaginaFim() > maior) {
                maior = volume.getPaginaFim();
            }
        }

        return maior;
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
            solicitacaoItem.setTraducaoMaterial(TraducaoMaterial.of(this.traducaoMaterial));
            solicitacaoItem.setOutro(this.outro);
            solicitacaoItem.setId(this.id);
            solicitacaoItem.setSolicitacao(this.solicitacao);
            solicitacaoItem.setStatus(StatusItem.of(this.status));

            if(solicitacaoItem.getTraducaoMaterial().equals(TraducaoMaterial.OUTRO)
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
                && !outroItem.traducaoMaterial.equals(TraducaoMaterial.OUTRO);
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
        for (Volume volume : volumes) {
            if (!volume.getStatus().equals(VolumeStatus.ENVIADO)) {
                throw new RuntimeException("Todos volumes precisam estar enviados para finalizar a ordem");
            }
        }

        setStatus(StatusItem.FINALIZADO);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
