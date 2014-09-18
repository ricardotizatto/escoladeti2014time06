package br.unicesumar.escoladeti.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.unicesumar.escoladeti.view.ViewAcompanhamentoSolicitacao;

public interface AcompanhamentoSolicitacaoRepository extends JpaRepository<ViewAcompanhamentoSolicitacao, Long>{     

    @Query(value = " from viewAcompanhamentoSolicitacao a "
            + "where a.dataChegada >= ?1 "
            + "and a.dataChegada <= ?2 "
            + "and CASE a.status WHEN 'TODOS' THEN  like nullif(?3,nullif(a.status,'todos')) "
            + "and nullif(a.material,'todos') like nullif(?4,nullif(a.material,'todos')) "
            + "and nullif(a.responsavel,'todos') like nullif(?5,nullif(a.responsavel,'todos')) "
            + "and nullif(a.revisor,'todos') like nullif(?6,nullif(a.revisor,'todos')) "
            + "and nullif(a.traducaoMaterial,'todos') like nullif(?7,nullif(a.traducaoMaterial,'todos'))", nativeQuery = false)
    public List<ViewAcompanhamentoSolicitacao> findByDataChegadaBetweenAndStatusContainingAndMaterialContainingAndResponsavelContainingAndRevisorContainingAndTraducaoMaterialContaining(
    		Date dataInicio, 
    		Date dataFim,
    		String status,
    		String material,
    		String responsavel,
    		String revisor,
    		String traducaoMaterial);
       
}
