package br.unicesumar.escoladeti.service;

import br.unicesumar.escoladeti.pesquisa.PesquisaSolicitacao;
import br.unicesumar.escoladeti.repository.ViewAcompanhamentoSolicitacaoRepository;
import br.unicesumar.escoladeti.view.ViewAcompanhamentoSolicitacao;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AcompanhamentoSolicitacaoService {
    
    @Autowired
    private ViewAcompanhamentoSolicitacaoRepository viewAcompanhamentoSolicitacaoRepository;

    //private SolicitacaoItemRepository solicitacaoItemRepository = new SolicitacaoItemRepository();
    
//    public List<AcompanhamentoDTO>listarItens(PesquisaSolicitacao pesquisa, DataSource dataSouce) {
//        return null; //solicitacaoItemRepository.listarItens(pesquisa, dataSouce);
//    }
    
    public List<ViewAcompanhamentoSolicitacao> listarItens() {
        return viewAcompanhamentoSolicitacaoRepository.findAll();
    }	

    public List<ViewAcompanhamentoSolicitacao> listarItensFiltrados(Date dataInicio, Date dataFim, String status) {
        return this.viewAcompanhamentoSolicitacaoRepository.findByStartDataChegadaBetweenAndItem(dataInicio,dataFim,status);
    }
}
