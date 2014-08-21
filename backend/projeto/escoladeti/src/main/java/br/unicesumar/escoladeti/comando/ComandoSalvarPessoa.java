package br.unicesumar.escoladeti.comando;

import br.unicesumar.escoladeti.enums.Papel;
import br.unicesumar.escoladeti.enums.Sexo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;
import javax.validation.constraints.NotNull;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.hibernate.validator.constraints.NotBlank;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ComandoSalvarPessoa {

//    @NotBlank(message = "Nome é obrigatório")
    private String nome;

//    @NotBlank(message = "Email é obrigatório")
    private String email;

//    @NotBlank(message = "Tipo inválido")
    private String tipo;

//    @NotBlank(message = "Rg é obrigatório")
    private String rg;

//    @NotBlank(message = "Cpf é obrigatório")
    private String cpf;

//    @NotNull(message = "Data de Nascimento é obrigatório")
    private Date dataNascimento;

//    @NotBlank(message = "Sobrenome é obrigatório")
    private String sobrenome;

//    @NotNull(message = "Sexo é obrigatório")
    private Sexo sexo;

//    @NotNull(message = "Aluno é obrigatório")
    private boolean aluno;

//    @NotBlank(message = "Cnpj é obrigatório")
    private String cnpj;

//    @NotBlank(message = "Inscrição Estadual é obrigatório")
    private String inscricaoEstadual;

//    @NotBlank(message = "Incrição Municipal é obrigatório")
    private String inscricaoMunicipal;

//    @NotBlank(message = "Razão Social é obrigatório")
    private String razaoSocial;

//    @NotNull(message = "Data de Criação é obrigatório")
    private Date dataCriacao;

    public ComandoSalvarPessoa() {

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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public boolean getAluno() {
        return aluno;
    }

    public void setPapel(boolean aluno) {
        this.aluno = aluno;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getInscricaoMunicipal() {
        return inscricaoMunicipal;
    }

    public void setInscricaoMunicipal(String inscricaoMunicipal) {
        this.inscricaoMunicipal = inscricaoMunicipal;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
    
}
