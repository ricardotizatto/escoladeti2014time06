package br.unicesumar.escoladeti.repository;

import br.unicesumar.escoladeti.entity.SolicitacaoItem;
import br.unicesumar.escoladeti.entity.SolicitacaoVolume;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Jhonatan on 22/10/2014.
 */
public interface SolicitacaoVolumeRepository extends JpaRepository<SolicitacaoVolume, Long> {
    List<SolicitacaoVolume> findByVolumeId(Long id);
}
