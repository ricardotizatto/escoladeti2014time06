package br.unicesumar.escoladeti.repository;

import br.unicesumar.escoladeti.entity.ParticipantePeriodo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantePeriodoRepository extends JpaRepository<ParticipantePeriodo, Long> {
    public List<ParticipantePeriodo> findByPeriodo_id(Long id);
}
