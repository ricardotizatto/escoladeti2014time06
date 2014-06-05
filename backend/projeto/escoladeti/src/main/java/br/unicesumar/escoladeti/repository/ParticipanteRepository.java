package br.unicesumar.escoladeti.repository;

import br.unicesumar.escoladeti.entity.Participante;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipanteRepository extends JpaRepository<Participante, Long>{
    public Participante findById(Long id);
    public List<Participante> findByIdevento(Long idevento);
    
    public List<Participante> findByNomeContainingOrderByNomeAsc(String nome);
}
