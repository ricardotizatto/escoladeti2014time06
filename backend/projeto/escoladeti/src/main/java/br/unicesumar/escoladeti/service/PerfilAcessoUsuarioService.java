package br.unicesumar.escoladeti.service;

import br.unicesumar.escoladeti.entity.PerfilAcessoUsuario;
import br.unicesumar.escoladeti.repository.PerfilAcessoUsuarioRepository;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerfilAcessoUsuarioService implements Serializable {

    @Autowired
    private PerfilAcessoUsuarioRepository perfilAcessoUsuarioRepository;

    public PerfilAcessoUsuario salvar(PerfilAcessoUsuario perfilAcessoUsuario) {
        this.perfilAcessoUsuarioRepository.deleteByUsuario(perfilAcessoUsuario.getUsuario());
        return this.perfilAcessoUsuarioRepository.save(perfilAcessoUsuario);
    }

    public void deletar(PerfilAcessoUsuario perfilAcessoUsuario) {
        this.perfilAcessoUsuarioRepository.delete(perfilAcessoUsuario);
    }
    
    public PerfilAcessoUsuario getById(Long id) {
        return this.perfilAcessoUsuarioRepository.findById(id);
    }

    public List<PerfilAcessoUsuario> getTodos() {
        return this.perfilAcessoUsuarioRepository.findAll();
    }
}
