package br.unicesumar.escoladeti.entity;

import br.unicesumar.escoladeti.util.data.DateUtil;
import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

@Entity
public class Periodo extends Entidade{
    
    private static final long serialVersionUID = 1L;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data;

    private String inicio;
    private String fim;
    
    @ManyToOne
    @JoinColumn(name = "eventoid", referencedColumnName = "id")
    @JsonBackReference
    private Evento evento;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFim() {
        return fim;
    }

    public void setFim(String fim) {
        this.fim = fim;
    }

    public boolean validaData() {
        return DateUtil.validBeforeDate(this.data);
    }
}
