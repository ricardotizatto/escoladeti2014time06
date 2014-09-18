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
            + "and coalesce(a.status,'TODOS') like '%' || CASE ?3 WHEN 'TODOS' THEN coalesce(a.status,'TODOS') ELSE ?3 END || '%' "
            + "and coalesce(a.material,'TODOS') like '%' || CASE ?4 WHEN 'TODOS' THEN coalesce(a.material,'TODOS') ELSE ?4 END || '%' "
            + "and coalesce(a.responsavel,'TODOS') like '%' || CASE ?5 WHEN 'TODOS' THEN coalesce(a.responsavel,'TODOS') ELSE ?5 END || '%' "
            + "and coalesce(a.revisor,'TODOS') like '%' || CASE ?6 WHEN 'TODOS' THEN coalesce(a.revisor,'TODOS') ELSE ?6 END || '%' "
            + "and coalesce(a.traducaoMaterial,'TODOS') like '%' || CASE ?7 WHEN 'TODOS' THEN coalesce(a.traducaoMaterial,'TODOS') ELSE ?7 END || '%' ", nativeQuery = false)
    public List<ViewAcompanhamentoSolicitacao> findByDataChegadaBetweenAndStatusContainingAndMaterialContainingAndResponsavelContainingAndRevisorContainingAndTraducaoMaterialContaining(
    		Date dataInicio, 
    		Date dataFim,
    		String status,
    		String material,
    		String responsavel,
    		String revisor,
    		String traducaoMaterial);
       
}
