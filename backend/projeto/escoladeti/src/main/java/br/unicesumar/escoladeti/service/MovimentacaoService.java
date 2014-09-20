package br.unicesumar.escoladeti.service;

import br.unicesumar.escoladeti.controller.DataPage;
import static br.unicesumar.escoladeti.controller.DataPage.pageRequestForAsc;
import br.unicesumar.escoladeti.entity.Movimentacao;
import br.unicesumar.escoladeti.repository.MovimentacaoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovimentacaoService {
    
    @Autowired
    private MovimentacaoRepository movimentacaoRepository;
    
    public Movimentacao salvar(Movimentacao movimentacao) throws Exception {
            return this.movimentacaoRepository.save(movimentacao);
    }
    
    public List<Movimentacao> listaTodos() {
        return this.movimentacaoRepository.findAll();
    }

    public DataPage<Movimentacao> getTodos(Integer pagina) {
        return new DataPage<>(movimentacaoRepository.findAll(pageRequestForAsc(pagina, "id")));
    }

    public void deletar(Movimentacao movimentacao) {
            this.movimentacaoRepository.delete(movimentacao);
    }

    public Movimentacao getById(Long id) {
            return this.movimentacaoRepository.findById(id);
    }
    
}
