package br.unicesumar.escoladeti.repository;

import br.unicesumar.escoladeti.entity.Cep;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CepRepository extends JpaRepository<Cep, Long>{
    public Cep findByCepContainingOrderByCepAsc(String cepParcial);
}
