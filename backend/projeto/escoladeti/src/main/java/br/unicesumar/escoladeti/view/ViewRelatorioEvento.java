package br.unicesumar.escoladeti.view;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "viewrelatorioevento")
public class ViewRelatorioEvento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id_periodo;
	private Long id;
	private String titulo;
	private String local;
	private String organizacao;
	private String tipo;
	private String tituloPeriodo;
	private String ministrante;
	private String status;
	@Temporal(TemporalType.DATE)
	private Date data;
	private String horario;
	private String participantes;

	public ViewRelatorioEvento() {
	}

	public Long getId_periodo() {
		return id_periodo;
	}

	public void setId_periodo(Long id_periodo) {
		this.id_periodo = id_periodo;
	}

	public String getParticipantes() {
		return participantes;
	}

	public void setParticipantes(String participantes) {
		this.participantes = participantes;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getOrganizacao() {
		return organizacao;
	}

	public void setOrganizacao(String organizacao) {
		this.organizacao = organizacao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTituloPeriodo() {
		return tituloPeriodo;
	}

	public void setTituloPeriodo(String tituloPeriodo) {
		this.tituloPeriodo = tituloPeriodo;
	}

	public String getMinistrante() {
		return ministrante;
	}

	public void setMinistrante(String ministrante) {
		this.ministrante = ministrante;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
