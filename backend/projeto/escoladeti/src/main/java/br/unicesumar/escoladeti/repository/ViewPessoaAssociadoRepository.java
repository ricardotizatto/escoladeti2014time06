package br.unicesumar.escoladeti.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.unicesumar.escoladeti.view.ViewPessoaAssociado;

public interface ViewPessoaAssociadoRepository extends JpaRepository<ViewPessoaAssociado, Long>{
	
	@Query(value = "from viewpessoaassociado a " +
			"where a.vigencia between ?1 and ?2 " +
			"and a.nome like '%' || CASE ?3 WHEN 'TODOS' THEN a.nome ELSE ?3 END || '%' " +
			"and a.pago like '%' || CASE ?4 WHEN 'TODOS' THEN a.pago ELSE ?4 END || '%'"
			,nativeQuery = false)
	public List<ViewPessoaAssociado> findByVigenciaBetweenAndNomeContainingAndPagoContainingOrderByNome(
			Date dataInicio,
			Date dataFim,
			String nome,
			String pago);

}
