package br.unicesumar.escoladeti.service;

import br.unicesumar.escoladeti.controller.DataPage;
import static br.unicesumar.escoladeti.controller.DataPage.pageRequestForAsc;
import br.unicesumar.escoladeti.entity.Livro;
import br.unicesumar.escoladeti.repository.LivroRepository;
import br.unicesumar.escoladeti.util.number.NumberUtils;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public Livro salvar(Livro livro) throws Exception {
        Long id = livro.getId() == null ? -1 : livro.getId();
        if (NumberUtils.isYearValid(livro.getAnoEdicao())) {
            if (!livro.equals(buscarLivroPorNomeAutorEditoraAnoEdicao(livro, id))) {
                return this.livroRepository.save(livro);
            }
            throw new Exception("O Livro " + livro.getNome() + " já está cadastrado!");
        }
        throw new Exception("O Ano não pode ser maior que o atual");

        //return this.livroRepository.save (livro);
    }
    public DataPage<Livro> getTodos(Integer pagina){
        return new DataPage<>(livroRepository.findAll(pageRequestForAsc(pagina, "nome")));
    }

    public List<Livro> getTodos(){
        return this.livroRepository.findAll();
    }

    public DataPage<Livro> getLivroPorNome(String nomeParcial) {
        return new DataPage<>(livroRepository.findByNomeContainingOrEditoraContainingOrDisciplinaContainingOrderByNomeAsc
        (nomeParcial, nomeParcial, nomeParcial, pageRequestForAsc(1, "nome")));
    }

    public void deletar(Livro livro) {
        this.livroRepository.delete(livro);
    }

    public Livro getById(Long id) {
        return this.livroRepository.findById(id);
    }

    public Livro buscarLivroPorNomeAutorEditoraAnoEdicao(Livro livro, Long id) {
        return this.livroRepository.findByNomeAndAutorAndEditoraAndAnoEdicaoAndIdNot(
                livro.getNome(), livro.getAutor(), livro.getEditora(), livro.getAnoEdicao(), id);
    }

    public DataPage<Livro> listarLivrosTranscritos(Integer pagina) {
        return new DataPage<>(livroRepository.findAll(pageRequestForAsc(pagina, "nome")));
    }   
    
    public DataPage<Livro> getTodos(int i, String q) {
        return new DataPage<>(livroRepository.findByNomeContainingOrderByNomeAsc(q, pageRequestForAsc(1, "nome")));
    }
}
