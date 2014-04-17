package br.com.repository;

import br.com.entity.ItemDeAcesso;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemDeAcessoRepository extends JpaRepository<ItemDeAcesso, Long> {
    
    ItemDeAcesso findById();
    
    List<ItemDeAcesso> findByNomeContainingOrderByNomeAsc(String nome);
    
}
