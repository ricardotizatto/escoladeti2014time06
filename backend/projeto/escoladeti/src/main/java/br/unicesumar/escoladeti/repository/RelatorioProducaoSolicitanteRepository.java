package br.unicesumar.escoladeti.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.unicesumar.escoladeti.view.ViewRelatorioProducaoSolicitante;


@Repository
public interface RelatorioProducaoSolicitanteRepository extends JpaRepository<ViewRelatorioProducaoSolicitante, Long>{

	@Query(value = "select distinct * from viewrelatorioproducaosolicitante where" + 
	" datachegada between ?1 and ?2 and" +
	" coalesce(dataimpressao,'0001-01-01') >= ?3 and" +
	" coalesce(dataimpressao,'9999-12-31') <= ?4 and " +
	" coalesce(datarevisao,'0001-01-01') >= ?5 and" +
	" coalesce(datarevisao,'9999-12-31') <= ?6 and" +
	" coalesce(dataenvio,'0001-01-01') >= ?7 and" +
	" coalesce(dataenvio,'9999-12-31') <= ?8"	, nativeQuery = true)
	public List<ViewRelatorioProducaoSolicitante> findByDatas(
			Date dataChegadaInicial,
			Date dataChegadaFinal,
			Date dataImpressaoInicial,
			Date dataImpressaoFinal,
			Date dataRevisaoInicial,
			Date dataRevisaoFinal,
			Date dataEnvioInicial,
			Date dataEnvioFinal
			);
}
