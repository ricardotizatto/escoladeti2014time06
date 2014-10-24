package br.unicesumar.escoladeti.entity;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class ParticipantePeriodo extends Entidade {
    @OneToOne
    private Periodo periodo;
    
    @ManyToOne
    @JoinColumn(name="id_participante")
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.periodo);
        hash = 29 * hash + Objects.hashCode(this.participante);
        hash = 29 * hash + (this.presente ? 1 : 0);
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
        final ParticipantePeriodo other = (ParticipantePeriodo) obj;
        if (!Objects.equals(this.periodo, other.periodo)) {
            return false;
        }
        if (!Objects.equals(this.participante, other.participante)) {
            return false;
        }
        if (this.presente != other.presente) {
            return false;
        }
        return true;
    }

}
