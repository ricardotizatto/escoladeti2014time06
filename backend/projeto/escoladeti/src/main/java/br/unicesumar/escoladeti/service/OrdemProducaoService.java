package br.unicesumar.escoladeti.service;

import br.unicesumar.escoladeti.controller.DataPage;
import static br.unicesumar.escoladeti.controller.DataPage.pageRequestForAsc;
import br.unicesumar.escoladeti.entity.OrdemProducao;
import br.unicesumar.escoladeti.repository.OrdemProducaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdemProducaoService {

    @Autowired
    private OrdemProducaoRepository ordemProducaoRepository;

    public OrdemProducao salvar(OrdemProducao ordemprocudao) {
        return ordemProducaoRepository.save(ordemprocudao);
    }

    public DataPage<OrdemProducao> getTodos(Integer pagina) {
        return new DataPage<>(ordemProducaoRepository.findAll(pageRequestForAsc(pagina, "id")));
    }

    public void deletar(OrdemProducao ordemProducao) {
        ordemProducaoRepository.delete(ordemProducao);
    }

    public OrdemProducao getById(Long id) {
        return ordemProducaoRepository.findById(id);
    }

}
