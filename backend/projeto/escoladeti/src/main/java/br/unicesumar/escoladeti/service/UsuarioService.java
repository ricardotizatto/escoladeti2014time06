package br.unicesumar.escoladeti.service;

import br.unicesumar.escoladeti.controller.DataPage;
import static br.unicesumar.escoladeti.controller.DataPage.pageRequestForAsc;
import br.unicesumar.escoladeti.dto.UsuarioDTO;
import br.unicesumar.escoladeti.entity.*;
import br.unicesumar.escoladeti.repository.*;
import br.unicesumar.escoladeti.view.ViewPerfilDeAcessoUsuario;

import java.util.Date;
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
    
    @Autowired
    private PerfilAcessoUsuarioRepository perfilAcessoUsuarioRepository;
    
    @Autowired
    private PerfilDeAcessoUsuarioViewRepository perfilDeAcessoUsuarioViewRepository;

    @Autowired
    private ItemAcessoRepository itemAcessoRepository;

    @Autowired
    private PerfilAcessoRepository perfilAcessoRepository;

    @Autowired
    private PerfilItemAcessoRepository perfilItemAcessoRepository;

    public UsuarioRepository getUsuarioRepository() {
        return usuarioRepository;
    }

    @Transactional
    public void inicializarUsuarioAdmin() {
        logger.info("Verificando existência do usuário 'admin'...");
        Usuario root = getUsuarioRepository().findByLogin("admin");
        if (root == null) {
            logger.info("Usuário 'admin' não encontrado, criando...");

            root = new Usuario("Administrador", "123mudar", "admin", "adminescoladeti@gmail.com");
            root.setAtivo(true);
            PerfilAcesso perfilAcesso = new PerfilAcesso();
            perfilAcesso.setNome("ADMINISTRADOR");
            List<ItemAcesso> todosItens = itemAcessoRepository.findAll();

            for(ItemAcesso itemAcesso: todosItens) {
                perfilAcesso.adcionarItem(itemAcesso.getId());
            }

            perfilAcessoRepository.save(perfilAcesso);

            PerfilAcessoUsuario perfilAcessoUsuario = new PerfilAcessoUsuario();
            Long umAnoAFrente = new Date().getTime() + 365 * 24 * 60 * 60 * 100;
            perfilAcessoUsuario.setFimVigencia(new Date(umAnoAFrente));
            perfilAcessoUsuario.setInicioVigencia(new Date());
            perfilAcessoUsuario.setPerfilAcesso(perfilAcesso);
            perfilAcessoUsuario.setUsuario(root);
            logger.debug("Salvando {}", root);
            getUsuarioRepository().save(root);

            perfilAcessoUsuarioRepository.save(perfilAcessoUsuario);

        }
        logger.info("Usuário 'admin' verificado.");
    }



    public UsuarioDTO salvar(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setId(usuarioDTO.getId());
        usuario.setLogin(usuarioDTO.getLogin());
        usuario.setNome(usuarioDTO.getNome());
        usuario.setSenha(usuarioDTO.getSenha());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setAtivo(usuarioDTO.getAtivo());
        
        Usuario usuSalvo = this.usuarioRepository.save(usuario);
         
        PerfilAcessoUsuario usuarioperfilacesso = new PerfilAcessoUsuario();
        usuarioperfilacesso.setId(usuarioDTO.getPerfilDeAcessoUsuarioId());
        usuarioperfilacesso.setInicioVigencia(usuarioDTO.getInicioVigencia());
        usuarioperfilacesso.setFimVigencia(usuarioDTO.getFimVigencia());
        usuarioperfilacesso.setUsuario(usuSalvo);
        
        PerfilAcesso pa = new PerfilAcesso();
        pa.setId(usuarioDTO.getPerfilAcessoId());
        pa.setNome("");
        usuarioperfilacesso.setPerfilAcesso(pa);
        
        this.perfilAcessoUsuarioRepository.save(usuarioperfilacesso);
        
        return usuarioDTO;
    }
    
    public DataPage<ViewPerfilDeAcessoUsuario> listarUsuarios(Integer pagina) {
       return new DataPage<>(perfilDeAcessoUsuarioViewRepository.findAll(pageRequestForAsc(pagina, "nome")));
    }
    
    public DataPage<ViewPerfilDeAcessoUsuario> getPerfilDeAcessoUsuarioPorNomeOrPerfilOrEmail(String nomeParcial) {
        return new DataPage<ViewPerfilDeAcessoUsuario>
        (perfilDeAcessoUsuarioViewRepository.findByNomeContainingOrPerfilContainingOrEmailContainingOrderByNomeAsc
        (nomeParcial, nomeParcial, nomeParcial, pageRequestForAsc(1, "nome")));  
    }
    
    public ViewPerfilDeAcessoUsuario getById(Long id) {
        return perfilDeAcessoUsuarioViewRepository.findById(id);
    }
    
    public void deletar(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setId(usuarioDTO.getId());

        PerfilAcessoUsuario perfilAcessoUsuario = new PerfilAcessoUsuario();
        perfilAcessoUsuario.setUsuario(usuario);

        this.perfilAcessoUsuarioRepository.deleteByUsuario(usuario);
        this.usuarioRepository.delete(usuario);
    }
    
    public List<Usuario> getTodos(){
        return usuarioRepository.findAll();
    }
   
}
