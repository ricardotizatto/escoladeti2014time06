package br.unicesumar.escoladeti.repository;

import br.unicesumar.escoladeti.view.ViewPeriodoEvento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeriodoEventoRepository extends JpaRepository<ViewPeriodoEvento , Long>{

    public Page<ViewPeriodoEvento> findByTituloContainingOrderByTituloAsc(String titulo, Pageable pageable);

    public Page<ViewPeriodoEvento> findByStatuseventoTrue(Pageable pageable);

    public Page<ViewPeriodoEvento> findByStatuseventoFalse(Pageable pageable);
}
