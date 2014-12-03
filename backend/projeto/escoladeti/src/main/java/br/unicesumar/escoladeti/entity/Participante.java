package br.unicesumar.escoladeti.entity;

import java.util.Objects;
import javax.persistence.Entity;

@Entity
public class Participante extends Entidade {

    private String nome;
    private Long idevento;
    private String email;
    private String telefone;
    private String deficiente;
    private String pagamento;
    private String necessidade;
    
    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }

    public Long getIdevento() {
        return idevento;
    }

    public void setIdevento(Long idevento) {
        this.idevento = idevento;
    }

    public String getNecessidade() {
        return necessidade.toUpperCase();
    }

    public void setNecessidade(String necessidade) {
        this.necessidade = necessidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome.toUpperCase();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email.toUpperCase();
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDeficiente() {
        return deficiente;
    }

    public void setDeficiente(String deficiente) {
        this.deficiente = deficiente.toUpperCase();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.nome);
        hash = 37 * hash + Objects.hashCode(this.idevento);
        hash = 37 * hash + Objects.hashCode(this.email);
        hash = 37 * hash + Objects.hashCode(this.telefone);
        hash = 37 * hash + Objects.hashCode(this.deficiente);
        hash = 37 * hash + Objects.hashCode(this.pagamento);
        hash = 37 * hash + Objects.hashCode(this.necessidade);
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
        final Participante other = (Participante) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.idevento, other.idevento)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        if (!Objects.equals(this.deficiente, other.deficiente)) {
            return false;
        }
        if (!Objects.equals(this.pagamento, other.pagamento)) {
            return false;
        }
        return true;
    }
    
    
}
