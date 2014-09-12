package br.unicesumar.escoladeti.service;

import br.unicesumar.escoladeti.controller.DataPage;
import static br.unicesumar.escoladeti.controller.DataPage.pageRequestForAsc;
import br.unicesumar.escoladeti.entity.Estoque;
import br.unicesumar.escoladeti.repository.EstoqueRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstoqueService {
     @Autowired
    private EstoqueRepository estoqueRepository;

    public Estoque salvar(Estoque estoque) throws Exception {
            return this.estoqueRepository.save(estoque);
    }
    
    public List<Estoque> listaTodos() {
        return this.estoqueRepository.findAll();
    }

    public DataPage<Estoque> getTodos(Integer pagina) {
        return new DataPage<>(estoqueRepository.findAll(pageRequestForAsc(pagina, "")));
    }

    public void deletar(Estoque estoque) {
            this.estoqueRepository.delete(estoque);
    }

    public Estoque getById(Long id) {
            return this.estoqueRepository.findById(id);
    }

//	public List<Estoque> buscarEstoquePorIdDoProduto(Long idProduto) {
//		return this.estoqueRepository.findByProdutoId(idProduto);
//	}

}
