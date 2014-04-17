package br.unicesumar.escoladeti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unicesumar.escoladeti.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    public Usuario findById();
    
    public List<Usuario> findByNomeContainingOrderByNomeAsc(String nome);
    
}
