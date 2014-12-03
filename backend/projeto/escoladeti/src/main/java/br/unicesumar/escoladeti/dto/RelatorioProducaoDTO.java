package br.unicesumar.escoladeti.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.unicesumar.escoladeti.view.ViewRelatorioProducaoSolicitante;
import br.unicesumar.escoladeti.view.ViewRelatorioProducaoVolume;

public class RelatorioProducaoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String aluno;
	private Integer idade;
	private String nascimentoCriacao;
	private String serie;
	private String ensino;
	private String responsavel;
	private String escola;
	private String endereco;
	private String telefone;
	private String email;
	private String municipioUf;
	private String bairro;
	private String complemento;
	private String cep;
	private String nre;
	private String datachegada;

	public List<ViewRelatorioProducaoVolume> volumes = new ArrayList<ViewRelatorioProducaoVolume>();

	public List<ViewRelatorioProducaoVolume> getVolumes() {
		return volumes;
	}

	public void setVolumes(List<ViewRelatorioProducaoVolume> volumes) {
		this.volumes = volumes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAluno() {
		return aluno;
	}

	public void setAluno(String aluno) {
		this.aluno = aluno;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getNascimentoCriacao() {
		return nascimentoCriacao;
	}

	public void setNascimentoCriacao(String nascimentoCriacao) {
		this.nascimentoCriacao = nascimentoCriacao;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getEnsino() {
		return ensino;
	}

	public void setEnsino(String ensino) {
		this.ensino = ensino;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public String getEscola() {
		return escola;
	}

	public void setEscola(String escola) {
		this.escola = escola;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMunicipioUf() {
		return municipioUf;
	}

	public void setMunicipioUf(String municipioUf) {
		this.municipioUf = municipioUf;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNre() {
		return nre;
	}

	public void setNre(String nre) {
		this.nre = nre;
	}

	public String getDatachegada() {
		return datachegada;
	}

	public void setDatachegada(String datachegada) {
		this.datachegada = datachegada;
	}

}
