package br.unicesumar.escoladeti.controller;

import br.unicesumar.escoladeti.entity.Livro;
import br.unicesumar.escoladeti.service.LivroService;
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
@RequestMapping("/rest/livroSource")
public class LivroController implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Autowired
    private LivroService livroService;

    @RequestMapping(value = "/livro", method = RequestMethod.POST)
    @ResponseBody
    public Livro salvar(@RequestBody Livro livro) {
        return this.livroService.salvar(livro);
    }

    @RequestMapping(value = "/livro/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Livro getById(@PathVariable Long id) {
        return this.livroService.getById(id);
    }

    @RequestMapping(value = "/livro", method = RequestMethod.GET)
    @ResponseBody
    public DataPage<Livro> getTodos() {
        return this.livroService.getTodos(1);
    }

    @RequestMapping(value = "/livro", params = {"q" }, method = RequestMethod.GET)
    @ResponseBody
    public DataPage<Livro> getPorNome(@RequestParam String q) {
        return livroService.getLivroPorNome(q);
    }

    @RequestMapping(value = {"/listar/pag/{pagina}"}, method = RequestMethod.GET)
    @ResponseBody
    public DataPage<Livro> listarLivro(@PathVariable Integer pagina) {
        return livroService.getTodos(pagina);
    }

    @RequestMapping(value = "/livro", method = RequestMethod.DELETE)
    @ResponseBody
    public void deletar(@RequestBody Livro livro) {
        this.livroService.deletar(livro);
    }
}
