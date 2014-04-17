package br.com.repository;

import br.com.entity.UsuarioPerfilAcesso;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioPerfilAcessoRepository extends JpaRepository<UsuarioPerfilAcesso, Long> {
    
    UsuarioPerfilAcesso findById();
    
    List<UsuarioPerfilAcesso> findByNomeContainingOrderByNomeAsc(String nome);
    
}
