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
    	if(this.status.isEmpty())
			return null;
		return status;
	}

	public String getTraducaoMaterial() {
		if(this.traducaoMaterial.isEmpty())
			return null;
		return traducaoMaterial;
	}


	public void setTraducaoMaterial(String traducaoMaterial) {
		this.traducaoMaterial = traducaoMaterial;
	}


	public void setStatus(String status) {
		if(status != null || !status.isEmpty())
			this.status = status.toUpperCase();
	}

	public String getMaterial() {
    	if(this.material.isEmpty())
			return null;
		return material;
	}

	public void setMaterial(String material) {
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
        if (responsavel != null) {
            this.responsavel = responsavel.toUpperCase();
        }
    }

    public String getRevisor() {
    	if(this.revisor.isEmpty())
			return null;
    	
        return revisor;
    }

    public void setRevisor(String revisor) {
        if (revisor != null) {
            this.revisor = revisor.toUpperCase();
        }
    }

}
