package br.unicesumar.escoladeti.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.unicesumar.escoladeti.enums.StatusItem;
import br.unicesumar.escoladeti.enums.TraducaoMaterial;

import java.util.List;

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
	@JoinColumn(name="id_solicitacao")
	@JsonIgnore
	private Solicitacao solicitacao;
	
	@Enumerated(EnumType.STRING)
	private StatusItem status;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "idItemSolicitacao")
    private List<Volume> volumes;

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

    public List<Volume> getVolumes() {
        return volumes;
    }

    public void setVolumes(List<Volume> volumes) {
        this.volumes = volumes;
    }

    public Long getNumeroSolicitacao() {
        return this.solicitacao.getId();
    }

    public static SolicitacaoItem criar(Long id) {
        return new SolicitacaoItem(id);
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
        if (!(obj instanceof  SolicitacaoItem)) {
            return false;
        }

        SolicitacaoItem outroItem = (SolicitacaoItem) obj;

        return outroItem.livro.equals(this.livro)
                && outroItem.traducaoMaterial.equals(this.traducaoMaterial)
                && !outroItem.traducaoMaterial.equals(TraducaoMaterial.OUTRO);
    }
}
