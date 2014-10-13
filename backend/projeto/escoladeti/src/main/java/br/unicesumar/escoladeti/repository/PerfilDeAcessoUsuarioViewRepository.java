package br.unicesumar.escoladeti.repository;

import br.unicesumar.escoladeti.view.ViewPerfilDeAcessoUsuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilDeAcessoUsuarioViewRepository extends JpaRepository<ViewPerfilDeAcessoUsuario, Long> {
    
    public Page<ViewPerfilDeAcessoUsuario> findByNomeContainingOrPerfilContainingOrEmailContainingOrderByNomeAsc(String nome, String perfil, String email, Pageable pageable);

    public ViewPerfilDeAcessoUsuario findById(Long id);

}
