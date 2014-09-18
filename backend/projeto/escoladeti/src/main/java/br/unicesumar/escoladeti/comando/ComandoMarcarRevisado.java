package br.unicesumar.escoladeti.comando;

import java.util.Date;

/**
 * Created by Jhonatan on 16/09/2014.
 */
public class ComandoMarcarRevisado {

    private Long revisor;
    private Date dataRevisao;

    public Long getRevisor() {
        return revisor;
    }

    public void setRevisor(Long revisor) {
        this.revisor = revisor;
    }

    public Date getDataRevisao() {
        return dataRevisao;
    }

    public void setDataRevisao(Date dataRevisao) {
        this.dataRevisao = dataRevisao;
    }
}
