package br.unicesumar.escoladeti.service;

import br.unicesumar.escoladeti.dto.AcompanhamentoDTO;
import br.unicesumar.escoladeti.pesquisa.PesquisaSolicitacao;
import br.unicesumar.escoladeti.repository.SolicitacaoItemRepository;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.stereotype.Service;

@Service
public class AcompanhamentoSolicitacaoService {

    //private SolicitacaoItemRepository solicitacaoItemRepository = new SolicitacaoItemRepository();
    
    public List<AcompanhamentoDTO>listarItens(PesquisaSolicitacao pesquisa, DataSource dataSouce) {
        return null; //solicitacaoItemRepository.listarItens(pesquisa, dataSouce);
    }
	
}
