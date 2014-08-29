package br.unicesumar.escoladeti.repository;

import br.unicesumar.escoladeti.entity.BuscaCep;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CepRepository extends JpaRepository<BuscaCep, Long> {

    public BuscaCep findByCepOrderByCepAsc(String cep);

}
