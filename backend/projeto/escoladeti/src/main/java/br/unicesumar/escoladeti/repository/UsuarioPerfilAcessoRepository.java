package br.unicesumar.escoladeti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unicesumar.escoladeti.entity.UsuarioPerfilAcesso;

public interface UsuarioPerfilAcessoRepository extends JpaRepository<UsuarioPerfilAcesso, Long> {
    public List<UsuarioPerfilAcesso> findByNomeContainingOrderByNomeAsc(String nome);
    
}
