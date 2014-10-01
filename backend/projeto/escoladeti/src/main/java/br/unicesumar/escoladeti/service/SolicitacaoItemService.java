package br.unicesumar.escoladeti.service;

import br.unicesumar.escoladeti.comando.ComandoAlterarData;
import br.unicesumar.escoladeti.dto.AcompanhamentoDTO;
import br.unicesumar.escoladeti.entity.SolicitacaoItem;
import br.unicesumar.escoladeti.entity.Volume;
import br.unicesumar.escoladeti.enums.StatusItem;
import br.unicesumar.escoladeti.repository.SolicitacaoItemRepository;
import br.unicesumar.escoladeti.repository.VolumeRepository;
import br.unicesumar.escoladeti.view.ViewAcompanhamentoSolicitacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jhonatan on 16/09/2014.
 */
@Service
public class SolicitacaoItemService {

    @Autowired
    private SolicitacaoItemRepository  solicitacaoItemRepository;

    @Autowired
    private VolumeRepository volumeRepository;

    public ViewAcompanhamentoSolicitacao enviarParaProducao(Long id) {
        SolicitacaoItem solicitacaoItem = solicitacaoItemRepository.findOne(id);
        solicitacaoItem.setStatus(StatusItem.PRODUCAO);

        SolicitacaoItem solicitacaoItemSalva = solicitacaoItemRepository.save(solicitacaoItem);

        return solicitacaoItemSalva.montarItemAcompanhamento();
    }



    @Transactional
    public ViewAcompanhamentoSolicitacao cancelarItem(Long id) {
        SolicitacaoItem solicitacaoItem = solicitacaoItemRepository.findOne(id);
        solicitacaoItem.cancelar(volumeRepository);

        return solicitacaoItemRepository.save(solicitacaoItem).montarItemAcompanhamento();
    }

    public SolicitacaoItem buscarItem(Long id) {
        return solicitacaoItemRepository.findOne(id);
    }

    public Map<String, Integer> sugerirPagina(Long idSolicitacaoItem) {
        Integer pagina = solicitacaoItemRepository.findOne(idSolicitacaoItem)
                .getMaiorPagina() + 1;

        Map<String, Integer> sugestao = new HashMap<>();

        sugestao.put("pagina", pagina);

        return sugestao;
    }

    @Transactional
    public SolicitacaoItem finalizar(Long id) {
        SolicitacaoItem solicitacaoItem = solicitacaoItemRepository.findOne(id);
        solicitacaoItem.finalizar();
        return solicitacaoItemRepository.save(solicitacaoItem);
    }



}
