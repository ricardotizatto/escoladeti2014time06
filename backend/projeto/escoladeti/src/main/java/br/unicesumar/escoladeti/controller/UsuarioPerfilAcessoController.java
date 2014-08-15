package br.unicesumar.escoladeti.controller;

import br.unicesumar.escoladeti.entity.PerfilAcesso;
import br.unicesumar.escoladeti.entity.Usuario;
import br.unicesumar.escoladeti.entity.UsuarioPerfilAcesso;
import br.unicesumar.escoladeti.service.UsuarioPerfilAcessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rest/usuarioPerfilAcessoSource")
public class UsuarioPerfilAcessoController {
    private static final long serialVersionUID = 1L;

    @Autowired
    private UsuarioPerfilAcessoService usuarioPerfilAcessoService;
   
    @RequestMapping(value = "/usuarioPerfilAcesso", method = RequestMethod.POST)
    @ResponseBody
    public UsuarioPerfilAcesso salvar(@RequestBody UsuarioPerfilAcesso usuarioPerfilAcesso) {
        System.out.println("Chegou aqui!" + usuarioPerfilAcesso.getUsuario().getNome() + usuarioPerfilAcesso.getPerfilAcesso().getNome() + usuarioPerfilAcesso.getInicioVigencia() + usuarioPerfilAcesso.getInicioVigencia());
        return this.usuarioPerfilAcessoService.salvar(usuarioPerfilAcesso);
    }
}
