package br.unicesumar.escoladeti.service;

import br.unicesumar.escoladeti.controller.DataPage;
import static br.unicesumar.escoladeti.controller.DataPage.pageRequestForAsc;
import br.unicesumar.escoladeti.entity.Produto;
import br.unicesumar.escoladeti.repository.ProdutoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto salvar(Produto produto) throws Exception {

        if (!produto.equals(buscarProdutoPorNome(produto))) {
            return this.produtoRepository.save(produto);
        }
        throw new Exception("O Produto " + produto.getNome() + " já está cadastrado!");
    }

    public DataPage<Produto> getTodos(Integer pagina) {
        return new DataPage<>(produtoRepository.findAll(pageRequestForAsc(pagina, "nome")));
    }

    public List<Produto> getTodos() {
        return this.produtoRepository.findAll();
    }

    public DataPage<Produto> getProdutoPorNome(String nomeParcial) {
        return new DataPage<>(produtoRepository.findByNomeContainingOrderByNomeAsc(nomeParcial, pageRequestForAsc(1, "nome")));
    }

    public void deletar(Produto produto) {
        this.produtoRepository.delete(produto);
    }

    public Produto getById(Long id) {
        return this.produtoRepository.findById(id);
    }

    public Produto buscarProdutoPorNome(Produto produto) {
        return this.produtoRepository.findByNome(
                produto.getNome());
    }

}
