package br.unicesumar.escoladeti.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Logradouro  {
    private String tipoEndereco;
    private String nome;
    
    public String getTipoEndereco() {
        return tipoEndereco;
    }

    public void setTipoEndereco(String tipoDoEndereco) {
        this.tipoEndereco = tipoDoEndereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
