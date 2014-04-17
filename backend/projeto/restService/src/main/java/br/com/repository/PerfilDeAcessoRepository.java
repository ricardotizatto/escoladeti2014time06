package br.com.repository;

import br.com.entity.PerfilDeAcesso;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilDeAcessoRepository extends JpaRepository<PerfilDeAcesso, Long> {
    
    PerfilDeAcesso findById();
    
    List<PerfilDeAcesso> findByNomeContainingOrderByNomeAsc(String nome);
    
}
