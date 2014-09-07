package br.unicesumar.escoladeti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unicesumar.escoladeti.entity.ItemAcesso;

public interface ItemAcessoRepository extends JpaRepository<ItemAcesso, Long> {

    public List<ItemAcesso> findByNomeContainingOrderByNomeAsc(String nome);

    public ItemAcesso findById(Long id);

}
