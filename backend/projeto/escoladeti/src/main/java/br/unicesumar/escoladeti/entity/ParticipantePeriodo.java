package br.unicesumar.escoladeti.entity;

import javax.persistence.Entity;

@Entity
public class ParticipantePeriodo extends Entidade {
    private Periodo periodo;
    private Participante participante;
    private boolean presente;

    public boolean isPresente() {
        return presente;
    }

    public void setPresente(boolean presente) {
        this.presente = presente;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

}
