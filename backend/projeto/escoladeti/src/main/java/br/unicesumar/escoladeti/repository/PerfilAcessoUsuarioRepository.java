package br.unicesumar.escoladeti.repository;

import br.unicesumar.escoladeti.entity.PerfilAcessoUsuario;
import br.unicesumar.escoladeti.entity.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface PerfilAcessoUsuarioRepository extends JpaRepository<PerfilAcessoUsuario, Long> {

    public PerfilAcessoUsuario findById(Long id);
    
    public List<PerfilAcessoUsuario> findByUsuarioId(Long id);

    @Modifying
    @Transactional
    @Query("delete from PerfilAcessoUsuario p where p.usuario = ?1")
    public void deleteByUsuario(Usuario usuario);
}
