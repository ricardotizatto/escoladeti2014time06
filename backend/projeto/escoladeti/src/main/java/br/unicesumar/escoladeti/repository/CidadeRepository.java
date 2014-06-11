package br.unicesumar.escoladeti.repository;

import br.unicesumar.escoladeti.entity.Cidade;
import br.unicesumar.escoladeti.entity.UnidadeFederativa;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
    public Cidade findById(Long id);
        
    /*public Cidade findByNomeAndFundacaoAndUnidadeFederativa(
            String nome, Date fundacao, UnidadeFederativa unidadeFederativa);
    */
    public Page<Cidade> findByNomeContainingOrderByNomeAsc(String nome, Pageable pageable);
}
