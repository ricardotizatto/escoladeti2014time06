package br.unicesumar.escoladeti.entity;

import br.unicesumar.escoladeti.util.data.DateUtil;
import br.unicesumar.escoladeti.util.number.NumberUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.parboiled.common.Preconditions;

@Entity
public class Livro extends Entidade {
    
    private static final long serialVersionUID = 1L;

    private String nome;
    private String disciplina;
    private String autor;
    private String editora;
    private Long anoEdicao;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_volume")
    private Set<Volume> volumes = new HashSet<>();
    
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

    public Set<Volume> getVolumes() {
        return volumes;
    }

    public void setVolumes(Set<Volume> volumes) {
        this.volumes = volumes;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Livro)) {
          return false;
        }

        Livro outroLivro = (Livro) obj;

        boolean igual = outroLivro.nome.equals(this.nome)
                && outroLivro.anoEdicao.equals(this.anoEdicao)
                && outroLivro.disciplina.equals(this.disciplina)
                && outroLivro.editora.equals(this.editora);

        return igual;
    }

	public static Livro of(Long id) {
		return new Livro(id);
	}
    
}