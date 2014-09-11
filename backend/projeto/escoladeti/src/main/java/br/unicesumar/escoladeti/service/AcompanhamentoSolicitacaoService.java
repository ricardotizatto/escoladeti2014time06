package br.unicesumar.escoladeti.service;

import br.unicesumar.escoladeti.entity.SolicitacaoItem;
import br.unicesumar.escoladeti.repository.SolicitacaoItemRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AcompanhamentoSolicitacaoService {
	
    @Autowired
    private SolicitacaoItemRepository solicitacaoItemRepository;

    public List<SolicitacaoItem> listar() {
        return solicitacaoItemRepository.findAll();
    }
	
}
