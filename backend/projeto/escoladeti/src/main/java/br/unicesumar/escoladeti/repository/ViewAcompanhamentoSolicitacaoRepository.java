package br.unicesumar.escoladeti.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.unicesumar.escoladeti.view.ViewAcompanhamentoSolicitacao;

public interface ViewAcompanhamentoSolicitacaoRepository extends JpaRepository<ViewAcompanhamentoSolicitacao, Long>{     

    @Query(value = " from viewAcompanhamentoSolicitacao a "
            + "where a.dataChegada >= ?1 "
            + "and a.dataChegada <= ?2 "
            + "and a.status = nullif(?3,a.status) "
            + "and a.material like %?4% "
            + "and a.responsavel like %?5% "
            + "and a.revisor like %?6% "
            + "and a.traducaoMaterial like %?7%", nativeQuery = false)
    public List<ViewAcompanhamentoSolicitacao> findByDataChegadaBetweenAndStatusContainingAndMaterialContainingAndResponsavelContainingAndRevisorContainingAndTraducaoMaterialContaining(
    		Date dataInicio, 
    		Date dataFim,
    		String status,
    		String material,
    		String responsavel,
    		String revisor,
    		String traducaoMaterial);
       
}
