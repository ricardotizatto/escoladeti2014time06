package br.unicesumar.escoladeti.controller;

import br.unicesumar.escoladeti.dto.UsuarioDTO;
import br.unicesumar.escoladeti.service.UsuarioService;
import br.unicesumar.escoladeti.view.ViewPerfilDeAcessoUsuario;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rest/usuarioSource")
public class UsuarioController implements Serializable {

    private static final long serialVersionUID = 1L;
    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping(value = "/usuario", method = RequestMethod.POST)
    @ResponseBody
    public UsuarioDTO salvar(@RequestBody UsuarioDTO usuarioDTO) {
        return this.usuarioService.salvar(usuarioDTO);
    }

    @RequestMapping(value = "/usuario/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ViewPerfilDeAcessoUsuario getById(@PathVariable Long id) {
        return this.usuarioService.getById(id);
    }
   
    @RequestMapping(value = {"/listar/pag/{pagina}"}, method = RequestMethod.GET)
    @ResponseBody
    public DataPage<ViewPerfilDeAcessoUsuario> listarUsuarios(@PathVariable Integer pagina) {
        return usuarioService.listarUsuarios(pagina);
    }
    
    @RequestMapping(value = "/usuarios", params = {"q"}, method = RequestMethod.GET)
    @ResponseBody
    public DataPage<ViewPerfilDeAcessoUsuario> getPorNome(@RequestParam String q) {
        return usuarioService.getPerfilDeAcessoUsuarioPorNomeOrPerfilOrEmail(q);
    }

    @RequestMapping(value = "/usuario", method = RequestMethod.DELETE)
    @ResponseBody
    public String deletar(@RequestBody UsuarioDTO usuarioDTO) {
        this.usuarioService.deletar(usuarioDTO);
        return "deleted";
    }
}
