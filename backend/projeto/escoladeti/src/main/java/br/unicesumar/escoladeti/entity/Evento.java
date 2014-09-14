package br.unicesumar.escoladeti.entity;

import br.unicesumar.escoladeti.util.data.DateUtil;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

@Entity
public class Evento extends Entidade {

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data;
    private String inicio;
    private String fim;
    private String tipoEvento;
    private String local;
    private String ministrante;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idevento", referencedColumnName = "id")
    private List<Participante> participante;
    private String organizacao;
    private String titulo;
    private String descricao;
    private double valor;
    private boolean statusevento;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;           
    }

        public String getOrganizacao() {
        return organizacao;
    }

    public void setOrganizacao(String organizacao) {
        this.organizacao = organizacao;
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

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
    
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public String getFim() {
        return fim;
    }

    public void setFim(String fim) {
        this.fim = fim;
    }
    
    public String getMinistrante() {
        return ministrante;
    }

    public void setMinistrante(String ministrante) {
        this.ministrante = ministrante;
    }
    
    public boolean validaData(){
        return DateUtil.validBeforeDate(this.data);
    }

    public boolean getStatusevento() {
        return statusevento;
    }

    public void setStatusevento(boolean statusevento) {
        this.statusevento = statusevento;
    }

}
