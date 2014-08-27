package br.unicesumar.escoladeti.comando;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ComandoSalvarSolicitacaoItem {
	@NotBlank(message = "Tradução do material é obrigatório")
	private String traducaoMaterial;
	
	@NotNull(message = "Livro é obrigatorio")
	@Min(value=0, message = "Livro é obrigatório")
	private Long livro;
	
	private String outro;
	
	private String status;
	
	public String getTraducaoMaterial() {
		return traducaoMaterial;
	}
	public void setTraducaoMaterial(String traducaoMaterial) {
		this.traducaoMaterial = traducaoMaterial;
	}
	public Long getLivro() {
		return livro;
	}
	public void setLivro(Long livro) {
		this.livro = livro;
	}
	public String getOutro() {
		return outro;
	}
	public void setOutro(String outro) {
		this.outro = outro;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
