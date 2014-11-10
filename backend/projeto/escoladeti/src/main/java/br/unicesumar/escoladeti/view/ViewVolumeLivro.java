package br.unicesumar.escoladeti.view;

import java.io.Serializable;
import javax.persistence.*;

@Entity(name = "viewvolumelivro")
public class ViewVolumeLivro implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;
    private Long livroid;
    private String nome;
    private String autor;
    private String editora;
    @Column(name="anoedicao")
    private Long anoEdicao;
    private String disciplina;
    private String transcricao;
    private String status;
    @Column(name="paginainicio")
    private Long paginaInicio;
    @Column(name = "paginafim")
    private Long paginaFim;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLivroid() {
        return livroid;
    }

    public void setLivroid(Long livroid) {
        this.livroid = livroid;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getPaginaInicio() {
        return paginaInicio;
    }

    public void setPaginaInicio(Long paginaInicio) {
        this.paginaInicio = paginaInicio;
    }

    public Long getPaginaFim() {
        return paginaFim;
    }

    public void setPaginaFim(Long paginaFim) {
        this.paginaFim = paginaFim;
    }
}
