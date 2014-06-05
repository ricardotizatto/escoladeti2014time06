package br.unicesumar.escoladeti.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unicesumar.escoladeti.entity.Distrito;

public interface DistritoRepository extends JpaRepository<Distrito, Long> {
    public Distrito findById(Long id);
}
