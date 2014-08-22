package br.unicesumar.escoladeti.repository;

import br.unicesumar.escoladeti.entity.BuscaCepUnico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CepUnicoRepository extends JpaRepository<BuscaCepUnico, Long> {

    public BuscaCepUnico findByCepOrderByCepAsc(String cepParcial);

}
