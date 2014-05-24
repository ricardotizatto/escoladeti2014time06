package br.unicesumar.escoladeti.controller;

import br.unicesumar.escoladeti.entity.Livro;
import br.unicesumar.escoladeti.service.LivroService;
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
@RequestMapping("/rest/livroSource")
public class LivroController implements Serializable{
    
    @Autowired
    private LivroService livroService;

    @ResponseBody
    @RequestMapping(value = "/livro", method = RequestMethod.POST)
    public Livro salvar(@RequestBody Livro livro) {
        return livroService.salvar(livro);
    }

    @RequestMapping(value = "/livro/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Livro getById(@PathVariable Long id) {
        return livroService.getById(id);
    }

    @RequestMapping(value = "/livro", method = RequestMethod.GET)
    @ResponseBody
    public List<Livro> getTodos() {
        return livroService.getTodos();
    }
    
    @RequestMapping(value = "/livro/{nome}", method = RequestMethod.GET)
    @ResponseBody
    public List<Livro> getByNome(String nome) {
        return livroService.getByName(nome);
    }

    @RequestMapping(value = "/livro", method = RequestMethod.DELETE)
    @ResponseBody
    public String deletar(@RequestBody Livro livro) {
        livroService.deletar(livro);
        return "deleted";
    }
}
