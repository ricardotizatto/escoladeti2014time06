package br.unicesumar.escoladeti.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.unicesumar.escoladeti.view.ViewPessoaAssociado;

public interface ViewPessoaAssociadoRepository extends
		JpaRepository<ViewPessoaAssociado, Long> {

	@Query(value = "from viewpessoaassociado a "
			+ "where a.vigencia between ?1 and ?2 "
			+ "and a.id = CASE ?3 WHEN 0 THEN a.id ELSE ?3 END "
			+ "and a.pago like '%' || CASE ?4 WHEN 'TODOS' THEN a.pago ELSE ?4 END || '%'", nativeQuery = false)
	public List<ViewPessoaAssociado> findByVigenciaBetweenAndIdAndPagoContainingOrderByNomeAscAndVigenciaAsc(
			Date dataInicio, Date dataFim, Long id, String pago);

}
