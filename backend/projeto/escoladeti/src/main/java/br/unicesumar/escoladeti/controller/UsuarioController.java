package br.unicesumar.escoladeti.controller;

import br.unicesumar.escoladeti.entity.Usuario;
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

@Controller
@RequestMapping("/rest/usuarioSource")
public class UsuarioController implements Serializable {

    private static final long serialVersionUID = 1L;
    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping(value = "/usuario", method = RequestMethod.POST)
    @ResponseBody
    public Usuario salvar(@RequestBody Usuario usuario) {
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
