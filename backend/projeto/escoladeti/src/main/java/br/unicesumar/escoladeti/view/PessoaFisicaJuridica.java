/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicesumar.escoladeti.view;

import br.unicesumar.escoladeti.entity.Entidade;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;

/**
 *
 * @author Walber
 */
@Entity(name = "viewpessoa")
public class PessoaFisicaJuridica extends Entidade implements Serializable{
    
    private String nome;
    
    private String email;
    
    private Character tipo;
    
    @Column(name = "cpf_cnpj")
    private String cpfCnpj;
    
    @Column(name = "rg_inscricaomunicipal")
    private String rgInscricaoMunicipal;
    
    @Column(name = "nascimento_criacao")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date nascimentoCriacao;
    
    
    private Boolean aluno;

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

    public Character getTipo() {
        return tipo;
    }

    public void setTipo(Character tipo) {
        this.tipo = tipo;
    }

    public String getCpfCnpj() {
        return this.cpfCnpj;
    }

    public void setCpfCnpj(String CpfCnpj) {
        this.cpfCnpj = CpfCnpj;
    }

    public String getRgInscricaoMunicipal() {
        return rgInscricaoMunicipal;
    }

    public void setRgInscricaoMunicipal(String rgInscricaoMunicipal) {
        this.rgInscricaoMunicipal = rgInscricaoMunicipal;
    }

    public Date getNascimentoCriacao() {
        return nascimentoCriacao;
    }

    public void setNascimentoCriacao(Date nascimentoCriacao) {
        this.nascimentoCriacao = nascimentoCriacao;
    }

    public Boolean getAluno() {
        return aluno;
    }

    public void setAluno(Boolean aluno) {
        this.aluno = aluno;
    }
    
}
