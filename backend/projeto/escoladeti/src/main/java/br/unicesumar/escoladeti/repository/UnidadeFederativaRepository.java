package br.unicesumar.escoladeti.repository;

import br.unicesumar.escoladeti.entity.Pais;
import br.unicesumar.escoladeti.entity.UnidadeFederativa;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnidadeFederativaRepository extends JpaRepository<UnidadeFederativa, Long> {
   
    public UnidadeFederativa findById(Long id);    
    
    public Page<UnidadeFederativa> findByNomeContainingOrderByNomeAsc(String nome, Pageable pageable);

    public UnidadeFederativa findByNomeAndSigla(String nome, String sigla);

	public List<UnidadeFederativa> findByPaisId(Long idPais);
}
