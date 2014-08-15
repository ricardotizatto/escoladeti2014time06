package br.unicesumar.escoladeti.repository;

import br.unicesumar.escoladeti.entity.CepUnico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CepUnicoRepository extends JpaRepository<CepUnico, Long>{
    public CepUnico findByCepContainingOrderByCepAsc(String cepParcial);
}
