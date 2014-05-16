/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicesumar.escoladeti.controller;

import br.unicesumar.escoladeti.entity.PerfilAcesso;
import br.unicesumar.escoladeti.service.PerfilAcessoService;
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
 * @author Walber
 */
@Controller
@RequestMapping("/rest/perfilAcessoSource")
public class PerfilAcessoController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private PerfilAcessoService perfilService;

    @RequestMapping(value = "/perfilAcesso", method = RequestMethod.POST)
    @ResponseBody
    public PerfilAcesso salvar(@RequestBody PerfilAcesso perfil) {
        System.out.println("Perfil" + perfil.getNome());
        return this.perfilService.salvar(perfil);
    }

    @RequestMapping(value = "/perfilAcesso/{id}", method = RequestMethod.GET)
    @ResponseBody
    public PerfilAcesso getById(@PathVariable Long id) {
        return this.perfilService.getById(id);
    }

    @RequestMapping(value = "/perfilAcesso", method = RequestMethod.GET)
    @ResponseBody
    public List<PerfilAcesso> getTodos() {
        return this.perfilService.getTodos();
    }

    @RequestMapping(value = "/perfilAcesso", method = RequestMethod.DELETE)
    @ResponseBody
    public String deletar(@RequestBody PerfilAcesso perfilAcesso) {
        this.perfilService.deletar(perfilAcesso);
        return "deleted";
    }
}
