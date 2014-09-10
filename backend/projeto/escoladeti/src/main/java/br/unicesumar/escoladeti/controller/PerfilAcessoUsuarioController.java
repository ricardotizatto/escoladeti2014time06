package br.unicesumar.escoladeti.controller;

import br.unicesumar.escoladeti.entity.PerfilAcessoUsuario;
import br.unicesumar.escoladeti.service.PerfilAcessoUsuarioService;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rest/perfilAcessoUsuarioSource")
public class PerfilAcessoUsuarioController implements Serializable {
    
    @Autowired
    private PerfilAcessoUsuarioService  perfilAcessoUsuarioService;
    
    @RequestMapping(value = "/perfilAcessoUsuario", method = RequestMethod.POST)
    @ResponseBody
    public PerfilAcessoUsuario salvar(@RequestBody PerfilAcessoUsuario perfilAcessoUsuario) {
        return this.perfilAcessoUsuarioService.salvar(perfilAcessoUsuario);
    }
}