package br.unicesumar.escoladeti.view;

import java.io.Serializable;
import javax.persistence.*;

@Entity(name = "viewmaterialproduzido")
public class ViewMaterialProduzido implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;
    private String nome;
    private String autor;
    private String editora;
    @Column(name="anoedicao")
    private Long anoEdicao;
    private String disciplina;
    private String transcricao;
    @Column(name="outratranscricao")
    private String outraTranscricao;
    private String status;

    
    public ViewMaterialProduzido(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public Long getAnoEdicao() {
        return anoEdicao;
    }

    public void setAnoEdicao(Long anoEdicao) {
        this.anoEdicao = anoEdicao;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getTranscricao() {
        return transcricao;
    }

    public void setTranscricao(String transcricao) {
        this.transcricao = transcricao;
    }

    public String getOutraTranscricao() {
        return outraTranscricao;
    }

    public void setOutraTranscricao(String outraTranscricao) {
        this.outraTranscricao = outraTranscricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
