package br.unicesumar.escoladeti.controller;

import br.unicesumar.escoladeti.entity.Produto;
import br.unicesumar.escoladeti.service.ProdutoService;
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
@RequestMapping("/rest/produtoSource")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @RequestMapping(value = "/produto", method = RequestMethod.POST)
    @ResponseBody
    public Produto salvar(@RequestBody Produto produto) throws Exception {
        System.out.println("salvando controller java");
        return this.produtoService.salvar(produto);
    }

    @RequestMapping(value = "/produto/atualizar", method = RequestMethod.POST)
    @ResponseBody
    public Produto atualizar(@RequestBody Produto produto) throws Exception {
        return this.produtoService.atualizar(produto);
    }
    
    @RequestMapping(value = "/produto/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Produto getById(@PathVariable Long id) {
        return this.produtoService.getById(id);
    }

    @RequestMapping(value = "/produto", method = RequestMethod.GET)
    @ResponseBody
    public DataPage<Produto> getTodos() {
        return this.produtoService.getTodos(1);
    }

    @RequestMapping(value = "/produtos", method = RequestMethod.GET)
    @ResponseBody
    public List<Produto> getTodosList() {
        return this.produtoService.getTodos();
    }

    @RequestMapping(value = "/produto", params = {"q"}, method = RequestMethod.GET)
    @ResponseBody
    public DataPage<Produto> getPorNome(@RequestParam String q) {
        return produtoService.getProdutoPorNome(q);
    }

    @RequestMapping(value = {"/listar/pag/{pagina}"}, method = RequestMethod.GET)
    @ResponseBody
    public DataPage<Produto> listarProduto(@PathVariable Integer pagina) {
        return produtoService.getTodos(pagina);
    }

    @RequestMapping(value = "/produto", method = RequestMethod.DELETE)
    @ResponseBody
    public String deletar(@RequestBody Produto produto) {
        this.produtoService.deletar(produto);
        return "ok";
    }
}
