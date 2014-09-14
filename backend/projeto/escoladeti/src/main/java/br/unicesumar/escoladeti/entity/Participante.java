package br.unicesumar.escoladeti.entity;

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
    private boolean presente;

    public boolean isPresente() {
        return presente;
    }

    public void setPresente(boolean presente) {
        this.presente = presente;
    }
    
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
        return necessidade;
    }

    public void setNecessidade(String necessidade) {
        this.necessidade = necessidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        this.deficiente = deficiente;
    }
}
