package br.unicesumar.escoladeti.entity;



import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Livro extends  Material  {
	private static final long serialVersionUID = 1L;
	@NotNull
    @NotEmpty
    private String nome;
    private String disciplina;
    private String autor;
    private String editora;
    private Long anoEdicao;

    public Livro() {
    }
    
    public Livro(String nome){
        this.nome = nome;
    }
    
    public Livro(String nome, String disciplina ) {
        this.nome = nome;
        this.disciplina = disciplina;
    }
    
    public Livro(String nome, String disciplina, String autor ) {
        this.nome = nome;
        this.disciplina = disciplina;
        this.autor = autor;
    }
    
    public Livro(String nome, String disciplina, String autor, String editora) {
        this.nome = nome;
        this.disciplina = disciplina;
        this.autor = autor;
        this.editora = editora;
    }
    
    public Livro(String nome, String disciplina, String autor, String editora, Long anoEdicao) {
        this.nome = nome;
        this.disciplina = disciplina;
        this.autor = autor;
        this.editora = editora;
        this.anoEdicao = anoEdicao;
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
	public String getInfo() {
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
