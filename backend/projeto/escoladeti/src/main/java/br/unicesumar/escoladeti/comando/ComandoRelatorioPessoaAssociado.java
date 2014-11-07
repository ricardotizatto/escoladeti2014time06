package br.unicesumar.escoladeti.comando;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ComandoRelatorioPessoaAssociado {

	private Date dataInicio;
	private Date dataFim;
	private String nome;
	private String pago;

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		try {
			if (dataInicio == null || dataInicio.isEmpty()) {
				this.dataInicio = sdf.parse("0001-01-31");
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome.equals(null) || nome.isEmpty())
			this.nome = "TODOS";
		else
			this.nome = "TODOS";
	}

	public String getPago() {
		return pago;
	}

	public void setPago(String pago) {
		if (pago.equals("TODOS") || pago.isEmpty())
			this.pago = "TODOS";
		else
			this.pago = pago;
	}

}
