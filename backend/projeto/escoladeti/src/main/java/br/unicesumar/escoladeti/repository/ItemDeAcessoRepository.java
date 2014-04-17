package br.unicesumar.escoladeti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unicesumar.escoladeti.entity.ItemAcesso;

public interface ItemDeAcessoRepository extends JpaRepository<ItemAcesso, Long> {
    
    public ItemAcesso findById();
    
    public List<ItemAcesso> findByNomeContainingOrderByNomeAsc(String nome);
    
}
