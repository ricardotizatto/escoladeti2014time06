package br.unicesumar.escoladeti.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.unicesumar.escoladeti.view.ViewRelatorioEvento;

@Repository
public interface RelatorioEventoRepository extends
		JpaRepository<ViewRelatorioEvento, Long> {

	@Query(value = "from viewrelatorioevento a "
			+ "where a.id = CASE ?1 WHEN 0 THEN a.id ELSE ?1 END "
			+ "and a.tipo like CASE ?2 WHEN 'TODOS' THEN a.tipo ELSE ?2 END "
			+ "and a.status like CASE ?3 WHEN 'TODOS' THEN a.status ELSE ?3 END "
			+ "and a.data between ?4 and ?5", nativeQuery = false)
	public List<ViewRelatorioEvento> findByIdAndTipoContainingAndStatusContainingAndDataBetween(
			Long id, String tipo, String status, Date dataInicio, Date dataFim);

	@Query(value = "select distinct a.id,a.titulo from viewrelatorioevento a order by a.titulo asc", nativeQuery = true)
	public List<Object[]> obterTitulosIdsDosEventos();
}
