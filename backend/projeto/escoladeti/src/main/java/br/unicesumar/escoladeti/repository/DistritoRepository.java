package br.unicesumar.escoladeti.repository;

import br.unicesumar.escoladeti.entity.Distrito;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

    public interface DistritoRepository extends JpaRepository<Distrito, Long> {
        public Distrito findById(Long id);
//        public Page<Distrito> findByNomeContainingOrderByNomeAsc(String nome, Pageable pageable);;
        
}
