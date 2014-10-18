package br.unicesumar.escoladeti.entity;

import br.unicesumar.escoladeti.util.data.DateUtil;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Evento extends Entidade {

    private String tipoEvento;
    private String local;
    private String ministrante;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idevento", referencedColumnName = "id", updatable = false)
    private List<Participante> participante;
    
    /*@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idevento", referencedColumnName = "id", updatable = false)*/
    @NotEmpty(message = "Deve ser cadastrado ao menos um Endereço!")
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "evento", cascade = CascadeType.ALL, orphanRemoval = true)    
    private Set<Periodo> periodos;    
    
    private String organizacao;
    private String titulo;
    private String descricao;
    private double valor;
    private boolean statusevento;

    public Evento() {
        this.periodos = new HashSet<Periodo>();
    }

    public Set<Periodo> getPeriodos() {
        return periodos;
    }

    public void setPeriodos(Set<Periodo> periodos) {
        this.periodos = periodos;
    }

    public String getOrganizacao() {
        return organizacao;
    }

    public void setOrganizacao(String organizacao) {
        this.organizacao = organizacao.toUpperCase();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo.toUpperCase();
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao.toUpperCase();
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento.toUpperCase();
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local.toUpperCase();
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getMinistrante() {
        return ministrante;
    }

    public void setMinistrante(String ministrante) {
        this.ministrante = ministrante.toUpperCase();
    }

    public boolean getStatusevento() {
        return statusevento;
    }

    public void setStatusevento(boolean statusevento) {
        this.statusevento = statusevento;
    }

}
