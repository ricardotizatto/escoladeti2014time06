package br.unicesumar.escoladeti.entity;

import br.unicesumar.escoladeti.util.data.DateUtil;
import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.Date;
import java.util.Objects;
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
    private String tituloperiodo;
    
    @ManyToOne
    @JoinColumn(name = "eventoid", referencedColumnName = "id")
    @JsonBackReference
    private Evento evento;

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

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
    
    public String getTituloperiodo() {
        return tituloperiodo;
    }

    public void setTituloperiodo(String tituloperiodo) {
        this.tituloperiodo = tituloperiodo;
    }

    public boolean validaData() {
        return DateUtil.validBeforeDate(this.data);
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.data);
        hash = 29 * hash + Objects.hashCode(this.inicio);
        hash = 29 * hash + Objects.hashCode(this.fim);
        hash = 29 * hash + Objects.hashCode(this.tituloperiodo);
        hash = 29 * hash + Objects.hashCode(this.evento);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Periodo other = (Periodo) obj;
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        if (!Objects.equals(this.inicio, other.inicio)) {
            return false;
        }
        if (!Objects.equals(this.fim, other.fim)) {
            return false;
        }
        if (!Objects.equals(this.tituloperiodo, other.tituloperiodo)) {
            return false;
        }
        if (!Objects.equals(this.evento, other.evento)) {
            return false;
        }
        return true;
    }
    
}
