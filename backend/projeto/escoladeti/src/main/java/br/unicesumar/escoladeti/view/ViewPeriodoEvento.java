package br.unicesumar.escoladeti.view;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity(name = "viewperiodoevento")
public class ViewPeriodoEvento implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;
    private String titulo;
    private String descricao;
    private String localevento;
    private boolean statusevento;
    @Temporal(TemporalType.DATE)
    private Date datainicio;
    
    public ViewPeriodoEvento(){
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLocalEvento() {
        return localevento;
    }
    public void setLocalEvento(String localevento) {
        this.localevento = localevento;
    }

    public boolean isStatusevento() {
        return statusevento;
    }
    public void setStatusevento(boolean statusevento) {
        this.statusevento = statusevento;
    }

    public Date getDataInicio() {
        return datainicio;
    }
    public void setDataInicio(Date datainicio) {
        this.datainicio = datainicio;
    }

}
