/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicesumar.escoladeti.controller;

import br.unicesumar.escoladeti.entity.PerfilAcesso;
import br.unicesumar.escoladeti.entity.Usuario;
import br.unicesumar.escoladeti.entity.UsuarioPerfilAcesso;
import br.unicesumar.escoladeti.repository.UsuarioPerfilAcessoRepository;
import br.unicesumar.escoladeti.service.UsuarioPerfilAcessoService;
import br.unicesumar.escoladeti.service.UsuarioService;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Diogo
 */
@Controller
@RequestMapping("/rest/usuarioSource")
public class UsuarioController implements Serializable {

    private static final long serialVersionUID = 1L;
    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping(value = "/usuario", method = RequestMethod.POST)
    @ResponseBody
    public Usuario salvar(@RequestBody Usuario usuario) {
        System.out.println(usuario.getUsuarioPerfilAcesso().getFimVigencia());
//        UsuarioPerfilAcesso upa = usuario.getUsuarioPerfilAcesso();
//        upa.setUsuario(usuario);
//        upa.setPerfilAcesso(usuario.getUsuarioPerfilAcesso().getPerfilAcesso());
        return this.usuarioService.salvar(usuario);
    }

    @RequestMapping(value = "/usuario/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Usuario getById(@PathVariable Long id) {
        return this.usuarioService.getById(id);
    }

    @RequestMapping(value = "/usuario", method = RequestMethod.GET)
    @ResponseBody
    public List<Usuario> getTodos() {
        return this.usuarioService.getTodos();
    }

    @RequestMapping(value = "/usuario", method = RequestMethod.DELETE)
    @ResponseBody
    public String deletar(@RequestBody Usuario usuario) {
        this.usuarioService.deletar(usuario);
        return "deleted";
    }
}
