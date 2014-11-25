package br.unicesumar.escoladeti.view;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity(name = "viewperiodoevento")
public class ViewPeriodoEvento implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;
//    private Long eventoid;
    private String titulo;
    private String descricao;
    private String local;
    private boolean statusevento;
    @Temporal(TemporalType.DATE)
    private Date datainicio;
//    private String periodoinicio;
//    private String tituloperiodo;

    public ViewPeriodoEvento(){
    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

//    public Long getEventoid() {
//        return eventoid;
//    }
//    public void setEventoid(Long eventoid) {
//        this.eventoid = eventoid;
//    }
    
    
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

    public String getLocal() {
        return local;
    }
    public void setLocal(String local) {
        this.local = local;
    }

    public boolean isStatusevento() {
        return statusevento;
    }
    public void setStatusevento(boolean statusevento) {
        this.statusevento = statusevento;
    }

    public Date getDatainicio() {
        return datainicio;
    }
    public void setDatainicio(Date datainicio) {
        this.datainicio = datainicio;
    }

//    public String getPeriodoinicio() {
//        return periodoinicio;
//    }
//    public void setPeriodoinicio(String periodoinicio) {
//        this.periodoinicio = periodoinicio;
//    }
//
//    public String getTituloperiodo() {
//        return tituloperiodo;
//    }
//    public void setTituloperiodo(String tituloperiodo) {
//        this.tituloperiodo = tituloperiodo;
//    }

}
