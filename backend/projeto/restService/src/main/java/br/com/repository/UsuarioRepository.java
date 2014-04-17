package br.com.repository;

import br.com.entity.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    Usuario findById();
    
    List<Usuario> findByNomeContainingOrderByNomeAsc(String nome);
    
}
