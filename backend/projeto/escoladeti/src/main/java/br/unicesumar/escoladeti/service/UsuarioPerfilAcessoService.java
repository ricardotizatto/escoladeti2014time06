package br.unicesumar.escoladeti.service;

import br.unicesumar.escoladeti.entity.Usuario;
import br.unicesumar.escoladeti.entity.UsuarioPerfilAcesso;
import br.unicesumar.escoladeti.repository.UsuarioPerfilAcessoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioPerfilAcessoService {
    
    @Autowired
    private UsuarioPerfilAcessoRepository usuarioPerfilAcessoRepository;

    public UsuarioPerfilAcesso salvar(UsuarioPerfilAcesso usuarioPerfilAcesso) {
        return usuarioPerfilAcessoRepository.save(usuarioPerfilAcesso);
    }

    public List<UsuarioPerfilAcesso> getTodos() {
        return usuarioPerfilAcessoRepository.findAll();
    }

    public void deletar(UsuarioPerfilAcesso usuarioPerfilAcesso) {
        usuarioPerfilAcessoRepository.delete(usuarioPerfilAcesso);
    }

    public UsuarioPerfilAcesso getById(Long id) {
        return usuarioPerfilAcessoRepository.findById(id);
    }

    public List<UsuarioPerfilAcesso> getByUsuario(Usuario usuario) {
        return usuarioPerfilAcessoRepository.findByUsuarioContainingOrderByIdAsc(usuario);
    }
}
