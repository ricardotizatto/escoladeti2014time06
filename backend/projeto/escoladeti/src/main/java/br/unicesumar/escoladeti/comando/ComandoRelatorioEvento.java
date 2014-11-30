package br.unicesumar.escoladeti.comando;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ComandoRelatorioEvento {
	private Long id;
	private String tipo;
	private String status;
	private Date dataInicio;
	private Date dataFim;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		if(id == null)
			this.id = 0L;
		else
			this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		if(tipo.equals("TODOS") || tipo.isEmpty())
			this.tipo = "TODOS";
		else
			this.tipo = tipo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		if(status.equals("TODOS") || status.isEmpty())
			this.status = "TODOS";
		else
			this.status = status;
	}
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(String dataInicio) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		try {
			if (dataInicio == null || dataInicio.isEmpty()) {
				this.dataInicio = sdf.parse("0001-01-01");
			} else {
				this.dataInicio = sdf.parse(dataInicio);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	public Date getDataFim() {
		return dataFim;
	}
	public void setDataFim(String dataFim) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		//SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		try {
			if (dataFim == null || dataFim.isEmpty()) {
				this.dataFim = sdf.parse("9999-12-31");
			} else {
				this.dataFim = sdf.parse(dataFim);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	
}
