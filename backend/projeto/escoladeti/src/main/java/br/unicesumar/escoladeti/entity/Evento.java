package br.unicesumar.escoladeti.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Evento extends Entidade {

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data;
    @ManyToOne
    @JoinColumn(name = "id_turno")
    private Turno turno;
    @OneToOne
    @JoinColumn(name = "id_tipoevento")
    private TipoEvento tipoEvento;
    private String local;

    /*@NotNull
    @NotEmpty
    @Column
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_participante")//@JoinColumn(name = "id_evento")*/
   // private List<Participante> participante;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_evento", referencedColumnName = "id")
    private List<Participante> participante;
    
    private String organizacao;
    private String titulo;

    //@Lob
    private String descricao;

    /*@NotNull
    @NotEmpty
    @Column
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_participante")
    private List<Participante> participantesEntidade;*/

    @ManyToOne
    @JoinColumn(name = "id_pagamento", nullable = true)
    private Pagamento pagamento;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

   /* public List<Participante> getParticipante() {
        return participante;
    }

    public void setParticipante(List<Participante> participante) {
        this.participante = participante;
    }*/

    public String getOrganizacao() {
        return organizacao;
    }

    public void setOrganizacao(String organizacao) {
        this.organizacao = organizacao;
    }

   /* public List<Participante> getParticipantesEntidade() {
        return participantesEntidade;
    }

    public void setParticipantesEntidade(List<Participante> participantesEntidade) {
        this.participantesEntidade = participantesEntidade;
    }*/

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
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
}
