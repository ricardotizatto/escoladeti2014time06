package br.unicesumar.escoladeti.repository;

import br.unicesumar.escoladeti.entity.Evento;
import br.unicesumar.escoladeti.entity.Periodo;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeriodoRepository extends JpaRepository<Periodo, Long> {

    public Periodo findById(Long id);
    
    public Collection<Periodo> findByEvento(Evento evento);

}
