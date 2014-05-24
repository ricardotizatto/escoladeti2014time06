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
        return livroRepository.save(livro);
    }

    public List<Livro> getTodos() {
        return livroRepository.findAll();
    }

    public List<Livro> getByName(String nome) {
        return livroRepository.findByNomeContainingOrderByNomeAsc(nome);
    }

    public void deletar(Livro livro) {
        livroRepository.delete(livro);
    }

    public Livro getById(Long id) {
        return livroRepository.findById(id);
    }
}
