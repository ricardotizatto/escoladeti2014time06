package br.unicesumar.escoladeti.repository;

import br.unicesumar.escoladeti.entity.Evento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, Long> {

    public Evento findById(Long id);

    public Page<Evento> findByTituloContainingOrderByTituloAsc(String titulo, Pageable pageable);
}
