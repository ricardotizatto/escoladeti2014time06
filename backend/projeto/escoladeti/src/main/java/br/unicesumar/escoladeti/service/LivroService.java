package br.unicesumar.escoladeti.service;

import br.unicesumar.escoladeti.controller.DataPage;
import static br.unicesumar.escoladeti.controller.DataPage.pageRequestForAsc;
import br.unicesumar.escoladeti.entity.Livro;
import br.unicesumar.escoladeti.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public Livro salvar(Livro livro) {
        return this.livroRepository.save(livro);
    }

    public DataPage<Livro> getTodos(Integer pagina){
        return new DataPage<>(livroRepository.findAll(pageRequestForAsc(pagina, "nome")));
    }

    public DataPage<Livro> getLivroPorNome(String nomeParcial) {
        return new DataPage<>(livroRepository.findByNomeContainingOrderByNomeAsc(nomeParcial, pageRequestForAsc(1, "nome")));
    }

    public void deletar(Livro livro) {
        this.livroRepository.delete(livro);
    }

    public Livro getById(Long id) {
        return this.livroRepository.findById(id);
    }

    public Livro buscarLivroPorNomeAutorEditoraAnoEdicao(Livro livro) {
        return this.livroRepository.findByNomeAndAutorAndEditoraAndAnoEdicao(
                livro.getNome(), livro.getAutor(), livro.getEditora(), livro.getAnoEdicao());
    }
}
