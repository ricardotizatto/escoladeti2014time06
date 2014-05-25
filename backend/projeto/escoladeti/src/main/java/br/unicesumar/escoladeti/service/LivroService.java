package br.unicesumar.escoladeti.service;

import br.unicesumar.escoladeti.entity.Livro;
import br.unicesumar.escoladeti.repository.LivroRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public Livro salvar(Livro livro) {
        return this.livroRepository.save(livro);
    }

    public List<Livro> getTodos() {
        return this.livroRepository.findAll();
    }

    public List<Livro> getByName(String nome) {
        return this.livroRepository.findByNomeContainingOrderByNomeAsc(nome);
    }

    public void deletar(Livro livro) {
        this.livroRepository.delete(livro);
    }

    public Livro getById(Long id) {
        return this.livroRepository.findById(id);
    }
}
