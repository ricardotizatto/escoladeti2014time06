package br.unicesumar.escoladeti.controller;

import br.unicesumar.escoladeti.entity.Estoque;
import br.unicesumar.escoladeti.service.EstoqueService;
import com.sun.jndi.toolkit.dir.SearchFilter;
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
@RequestMapping("/rest/estoqueSource")
    public class EstoqueController implements Serializable  {
     private static final long serialVersionUID = 1L;
    @Autowired
    private EstoqueService estoqueService;

    @RequestMapping(value="/estoque", method= RequestMethod.POST)
    @ResponseBody
    public Estoque salvar(@RequestBody Estoque estoque) throws Exception {
            return this.estoqueService.salvar(estoque);
    }

    @RequestMapping(value="/estoque", method= RequestMethod.DELETE)
    @ResponseBody
    public String deletar(@RequestBody Estoque estoque) {
        estoqueService.deletar(estoque);
        return "arquivo deletado";		
    }
    
    @RequestMapping(value = {"/listar/pag/{pagina}"}, method = RequestMethod.GET)
    @ResponseBody
    public DataPage<Estoque> listarEstoque(@PathVariable Integer pagina) {
        return estoqueService.getTodos(pagina);
    }
    
    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    @ResponseBody
    public List<Estoque> listaTodos() {
        return estoqueService.listaTodos();
    }

    @RequestMapping(value= "/estoque/{id}", method= RequestMethod.GET)
    @ResponseBody
    public Estoque findById(@PathVariable Long id) {
        return this.estoqueService.getById(id);
    }
//    @RequestMapping(value="/listarPorProduto/{idProduto}",method = RequestMethod.GET)
//    @ResponseBody
//    public List<Estoque> listaPorProduto(@PathVariable Long idProduto){
//    	return this.estoqueService.buscarEstoquePorIdDoProduto(idProduto);
//    }
}
