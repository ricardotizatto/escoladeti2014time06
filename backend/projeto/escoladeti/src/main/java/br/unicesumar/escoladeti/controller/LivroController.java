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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rest/livroSource")
public class LivroController implements Serializable {

    @Autowired
    private LivroService livroService;

    @RequestMapping(value = "/livro", method = RequestMethod.POST)
    @ResponseBody
    public Livro salvar(@RequestBody Livro livro) throws Exception {
//        if (livro.isYearValid()) {
//            if (!livro.equals(livroService.buscarLivroPorNomeAutorEditoraAnoEdicao(livro))) {
//                return this.livroService.salvar(livro);
//            }
//          throw new Exception("O Livro " + livro.getNome() + " já está cadastrado!");
//        }
//        throw new Exception("O Ano não pode ser maior que o atual");
//    }
    return this.livroService.salvar(livro);}
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

    @RequestMapping(value = "/livros", method = RequestMethod.GET)
    @ResponseBody
    public List<Livro> getTodosList() {
        return this.livroService.getTodos();
    }

    @RequestMapping(value = "/livro", params = {"q"}, method = RequestMethod.GET)
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
    public String deletar(@RequestBody Livro livro) {
        this.livroService.deletar(livro);
        return "ok";
    }
}
