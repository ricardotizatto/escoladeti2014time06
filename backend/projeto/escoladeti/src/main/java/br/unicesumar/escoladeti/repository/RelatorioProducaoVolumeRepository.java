package br.unicesumar.escoladeti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.unicesumar.escoladeti.view.ViewRelatorioProducaoVolume;

@Repository
public interface RelatorioProducaoVolumeRepository extends JpaRepository<ViewRelatorioProducaoVolume, Long>{

	List<ViewRelatorioProducaoVolume> findBySolicitacaoid(Long id);

}
