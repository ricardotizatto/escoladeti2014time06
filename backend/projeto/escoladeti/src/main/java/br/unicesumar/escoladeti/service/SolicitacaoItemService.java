package br.unicesumar.escoladeti.service;

import br.unicesumar.escoladeti.comando.ComandoAlterarData;
import br.unicesumar.escoladeti.entity.SolicitacaoItem;
import br.unicesumar.escoladeti.entity.Volume;
import br.unicesumar.escoladeti.enums.StatusItem;
import br.unicesumar.escoladeti.repository.SolicitacaoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Jhonatan on 16/09/2014.
 */
@Service
public class SolicitacaoItemService {

    @Autowired
    private SolicitacaoItemRepository  solicitacaoItemRepository;

    public SolicitacaoItem enviarParaProducao(Long id) {
        SolicitacaoItem solicitacaoItem = solicitacaoItemRepository.findOne(id);
        solicitacaoItem.setStatus(StatusItem.PRODUCAO);

        return solicitacaoItemRepository.save(solicitacaoItem);
    }

    public SolicitacaoItem cancelarItem(Long id) {
        SolicitacaoItem solicitacaoItem = solicitacaoItemRepository.findOne(id);
        solicitacaoItem.setStatus(StatusItem.CANCELADO);
        return solicitacaoItemRepository.save(solicitacaoItem);
    }

    public SolicitacaoItem buscarItem(Long id) {
        return solicitacaoItemRepository.findOne(id);
    }




}
