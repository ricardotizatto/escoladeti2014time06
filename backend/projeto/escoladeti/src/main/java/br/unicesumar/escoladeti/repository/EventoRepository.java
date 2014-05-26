package br.unicesumar.escoladeti.repository;

import br.unicesumar.escoladeti.entity.Evento;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, Long>{
    public Evento findById(Long id);
    
    public List<Evento> findByTituloContainingOrderByTituloAsc(String titulo);
}
