package br.unicesumar.escoladeti.pesquisa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PesquisaSolicitacao {

    private String status;
    private Date dataChegadaInicio;
    private Date dataChegadaFim;
    private Long solicitacaoId;
    private String traducaoMaterial;
    private String material;
    
    public String getStatus() {
		return status;
	}

	public String getTraducaoMaterial() {
		return traducaoMaterial;
	}


	public void setTraducaoMaterial(String traducaoMaterial) {
		if(traducaoMaterial.isEmpty())
			this.traducaoMaterial = "TODOS";
		else
			this.traducaoMaterial = traducaoMaterial;
	}


	public void setStatus(String status) {
		if(status != null || !status.isEmpty())
			this.status = status.toUpperCase();
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		if(material.isEmpty())
			this.material = "TODOS";
		else
			this.material = material;
	}

	private String responsavel;
    private String revisor;

    public Date getDataChegadaInicio() {
        return dataChegadaInicio;
    }

    public void setDataChegadaInicio(String dataChegadaInicio) {
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");    		

		try {
			if(dataChegadaInicio == null || dataChegadaInicio.isEmpty()){
				this.dataChegadaInicio = sdf.parse("0001-01-31");
			} else {
				this.dataChegadaInicio = sdf.parse(dataChegadaInicio);
			}
		}catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}

    public Date getDataChegadaFim() {
        return dataChegadaFim;
    }

    
	public void setDataChegadaFim(String dataChegadaFim) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");    		

		try {
			if(dataChegadaFim == null || dataChegadaFim.isEmpty()){
				this.dataChegadaFim = sdf.parse("9999-12-31");
			} else {
				this.dataChegadaFim = sdf.parse(dataChegadaFim);
			}
		}catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
        

    public Long getSolicitacaoId() {
        return solicitacaoId;
    }

    public void setSolicitacaoId(Long solicitacaoId) {
        this.solicitacaoId = solicitacaoId;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
    	if(responsavel.isEmpty())
    		this.responsavel = "TODOS";
    	else
    		this.responsavel = responsavel;
    }

    public String getRevisor() {
        return revisor;
    }

    public void setRevisor(String revisor) {
    	if(revisor.isEmpty())
    		this.revisor = "TODOS";
    	else
    		this.revisor = revisor;
    }

}
