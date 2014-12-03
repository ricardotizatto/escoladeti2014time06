package br.unicesumar.escoladeti.view;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.junit.Ignore;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "viewrelatorioproducaovolume")
public class ViewRelatorioProducaoVolume implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long solicitacaoid;
	private Long solicitacaoitemid;
	@Id
	private Long volumeid;
	private String nome;
	private String disciplina;
	private String autor;
	private String editora;
	private Integer anoedicao;
	private String transcricao;
	private Integer paginaInicio;
	private Integer paginaFim;
	private String status;
	private String responsavel;
	private Date dataChegada;
	private Date dataImpressao;
	private Date dataRevisao;
	private Date dataEnvio;

	public ViewRelatorioProducaoVolume() {
	}
	
	public Long getSolicitacaoid() {
		return solicitacaoid;
	}

	public void setSolicitacaoid(Long solicitacaoid) {
		this.solicitacaoid = solicitacaoid;
	}

	public Long getSolicitacaoitemid() {
		return solicitacaoitemid;
	}

	public void setSolicitacaoitemid(Long solicitacaoitemid) {
		this.solicitacaoitemid = solicitacaoitemid;
	}

	public Long getVolumeid() {
		return volumeid;
	}

	public void setVolumeid(Long volumeid) {
		this.volumeid = volumeid;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public Integer getAnoedicao() {
		return anoedicao;
	}

	public void setAnoedicao(Integer anoedicao) {
		this.anoedicao = anoedicao;
	}

	public String getTranscricao() {
		return transcricao;
	}

	public void setTranscricao(String transcricao) {
		this.transcricao = transcricao;
	}

	public Integer getPaginaInicio() {
		return paginaInicio;
	}

	public void setPaginaInicio(Integer paginaInicio) {
		this.paginaInicio = paginaInicio;
	}

	public Integer getPaginaFim() {
		return paginaFim;
	}

	public void setPaginaFim(Integer paginaFim) {
		this.paginaFim = paginaFim;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public String getDataChegada() {
		if(this.dataChegada == null)
			return "";
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		return sdf.format(dataChegada);
	}

	public void setDataChegada(Date dataChegada) {
		this.dataChegada = dataChegada;
	}

	public String getDataImpressao() {
		if(this.dataImpressao == null)
			return "";
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		return sdf.format(dataImpressao);
	}

	public void setDataImpressao(Date dataImpressao) {
		this.dataImpressao = dataImpressao;
	}

	public String getDataRevisao() {
		if(this.dataRevisao == null)
			return "";
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		return sdf.format(dataRevisao);
	}

	public void setDataRevisao(Date dataRevisao) {
		this.dataRevisao = dataRevisao;
	}

	public String getDataEnvio() {
		if(this.dataEnvio == null)
			return "";
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		return sdf.format(dataEnvio);
	}

	public void setDataEnvio(Date dataEnvio) {
		this.dataEnvio = dataEnvio;
	}

}
