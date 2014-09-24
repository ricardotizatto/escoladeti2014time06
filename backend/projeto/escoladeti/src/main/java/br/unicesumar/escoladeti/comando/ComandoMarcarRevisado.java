package br.unicesumar.escoladeti.comando;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

/**
 * Created by Jhonatan on 16/09/2014.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ComandoMarcarRevisado {

    private Long revisor;
    private Date data;

    public Long getRevisor() {
        return revisor;
    }

    public void setRevisor(Long revisor) {
        this.revisor = revisor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
