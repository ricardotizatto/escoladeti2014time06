package br.unicesumar.escoladeti.service;

import br.unicesumar.escoladeti.entity.Usuario;
import br.unicesumar.escoladeti.repository.UsuarioRepository;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsuarioService {

    private static final Logger logger = LoggerFactory.getLogger(UsuarioService.class);
    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioRepository getUsuarioRepository() {
        return usuarioRepository;
    }

    public void inicializarUsuarioAdmin() {
        logger.info("Verificando existência do usuário 'admin'...");
        Usuario root = getUsuarioRepository().findByLogin("admin");
        if (root == null) {
            logger.info("Usuário 'admin' não encontrado, criando...");

            root = new Usuario("Administrador", "123mudar", "admin", "adminescoladeti@gmail.com");
            root.setAtivo(true);

            logger.debug("Salvando {}", root);
            getUsuarioRepository().save(root);

            inicializarUsuarios();
        }
        logger.info("Usuário 'admin' verificado.");
    }

    private void inicializarUsuarios() {
    }

    // Daqui pra baixo
    public Usuario salvar(Usuario usuario) {
        return this.usuarioRepository.save(usuario);
    }

    public List<Usuario> getTodos() {
        return this.usuarioRepository.findAll();
    }

    public void deletar(Usuario usuario) {
        this.usuarioRepository.delete(usuario);
    }

    public Usuario getById(Long id) {
        return this.usuarioRepository.findById(id);
    }
}
