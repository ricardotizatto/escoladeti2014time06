package br.unicesumar.escoladeti.entity;

import br.unicesumar.escoladeti.common.Material;
import javax.persistence.Entity;

@Entity
public class Livro extends Entidade implements Material  {

    private String nome;
    private String disciplina;
    private String autor;
    private String editora;
    private Long anoEdicao;

    public Livro() {
    }
  
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
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

    @Override
    public String getDados() {
        StringBuilder dados = new StringBuilder();
        
        dados.append("Nome: ");
        dados.append(getNome());
        dados.append(" Autor: ");
        dados.append(getAutor());
        dados.append(" Disciplina: ");
        dados.append(getDisciplina());
        dados.append(" Editora: ");
        dados.append(getEditora());
        dados.append(" Edição: ");
        dados.append(getAnoEdicao());        
        
        return dados.toString();
    }
}
