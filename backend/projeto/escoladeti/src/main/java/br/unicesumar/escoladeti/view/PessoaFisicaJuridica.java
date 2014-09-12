/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicesumar.escoladeti.view;

import br.unicesumar.escoladeti.entity.Entidade;
import br.unicesumar.escoladeti.mask.Mascara;
import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.swing.text.MaskFormatter;

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
        if(this.getTipo() == 'F'){
            if(this.cpfCnpj.isEmpty() || this.cpfCnpj == null)
                return "";
            return Mascara.cpf(this.cpfCnpj);
        }
        return Mascara.cpnj(this.cpfCnpj);
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
