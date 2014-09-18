package br.unicesumar.escoladeti.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.unicesumar.escoladeti.view.ViewAcompanhamentoSolicitacao;

public interface ViewAcompanhamentoSolicitacaoRepository extends JpaRepository<ViewAcompanhamentoSolicitacao, Long>{     

//    @Query(value = "select a "
//            + "from viewAcompanhamentoSolicitacao a "
//            + "where a.datachegada between :dataInicio and :dataFim "
//            + "and a.itemStatus like :filtroStatus", nativeQuery = false)
    public List<ViewAcompanhamentoSolicitacao> findByDatachegadaBetweenAndItemStatusContaining(
    		Date dataInicio, 
    		Date dataFim,
    		String itemStatus);
       
}
