package br.unicesumar.escoladeti.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import br.unicesumar.escoladeti.common.TraducaoMaterial;

@Entity
public class SolicitacaoItem extends Entidade{
	private static final long serialVersionUID = 1L;
	private String pnld;
	
	@NotNull
	@NotEmpty
	@Enumerated(EnumType.STRING)
	private TraducaoMaterial traducaoMaterial;
	
	@ManyToOne
	@NotEmpty
	@JoinColumn(name="id_material", nullable=false)
	private Material material;
	
	public SolicitacaoItem() {
	}
	
	public SolicitacaoItem(String pnld, TraducaoMaterial traducaoMaterial) {
		this.pnld = pnld;
		this.traducaoMaterial = traducaoMaterial;
	}
	
	public void setPnld(String pnld) {
		this.pnld = pnld;
	}
	
	
}
