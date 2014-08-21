package br.unicesumar.escoladeti.repository;

import br.unicesumar.escoladeti.entity.BuscaCepUnico;
import br.unicesumar.escoladeti.entity.CepUnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CepUnicoRepository extends JpaRepository<CepUnico, Long>{
    public CepUnico findByCepOrderByCepAsc(String cepParcial);
    
    
}
