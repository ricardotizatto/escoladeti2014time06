package br.unicesumar.escoladeti.entity;

import java.util.Objects;

import javax.persistence.Entity;

@Entity
public class Livro extends Entidade {
    
    private static final long serialVersionUID = 1L;

    private String nome;
    private String disciplina;
    private String autor;
    private String editora;
    private Long anoEdicao;
    
    public Livro() {
	}

    public Livro(Long id) {
    	this.id = id;
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
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.nome);
        hash = 83 * hash + Objects.hashCode(this.disciplina);
        hash = 83 * hash + Objects.hashCode(this.autor);
        hash = 83 * hash + Objects.hashCode(this.editora);
        hash = 83 * hash + Objects.hashCode(this.anoEdicao);
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
        final Livro other = (Livro) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.disciplina, other.disciplina)) {
            return false;
        }
        if (!Objects.equals(this.autor, other.autor)) {
            return false;
        }
        if (!Objects.equals(this.editora, other.editora)) {
            return false;
        }
        if (!Objects.equals(this.anoEdicao, other.anoEdicao)) {
            return false;
        }
        return true;
    }

	public static Livro of(Long id) {
		return new Livro(id);
	}
    
    
}