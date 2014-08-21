package br.unicesumar.escoladeti.repository;

import br.unicesumar.escoladeti.entity.PerfilAcessoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilAcessoUsuarioRepository extends JpaRepository<PerfilAcessoUsuario, Long>{
    public PerfilAcessoUsuario findById(Long id);
}
