
package br.unicesumar.escoladeti.controller;

import br.unicesumar.escoladeti.entity.Cidade;
import br.unicesumar.escoladeti.service.CidadeService;
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
@RequestMapping("/rest/cidadeSource")
public class CidadeController implements Serializable {
    private static final long serialVersionUID = 1L;
    @Autowired
    private CidadeService cidadeService;
    
    @RequestMapping(value= "/cidade", method = RequestMethod.POST)
    @ResponseBody
    public Cidade salvar(@RequestBody Cidade cidade){
        return this.cidadeService.salvar(cidade);
    }
    
    @RequestMapping(value = "/cidade", method = RequestMethod.PUT)
    @ResponseBody
    public Cidade editar(@RequestBody Cidade cidade){
        Cidade cidadeEditada = this.cidadeService.getById(cidade.getId());
        System.out.println("Cidade " + cidade.getId());
        return cidadeService.salvar(cidadeEditada);
    }
    
    @RequestMapping(value = "/cidade/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Cidade getById(@PathVariable Long id){
        return this.cidadeService.getById(id);
    }
    
    @RequestMapping(value = "/cidade", method = RequestMethod.GET)
    @ResponseBody
    public DataPage<Cidade> getTodos(){
        return cidadeService.getTodos(1);
    }
    
    @RequestMapping(value = "/cidade",params = {"q"}, method = RequestMethod.GET)
    @ResponseBody
    public DataPage<Cidade> getPorNome(@RequestParam String q){
        return cidadeService.getCidadePorNome(q);
    }
    
    @RequestMapping(value = { "/listar/pag/{pagina}" }, method = RequestMethod.GET)
    @ResponseBody
    public DataPage<Cidade> listarCidade(@PathVariable Integer pagina){
    	//throw new RuntimeException("Teste " + cidadeService.getTodos(pagina));
        return cidadeService.getTodos(pagina);
    }
    @RequestMapping(value = "/cidade", method = RequestMethod.DELETE)
    @ResponseBody
    public String deletar(@RequestBody Cidade cidade){
        cidadeService.deletar(cidade);
        return "deleted";
    }
    
    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    @ResponseBody
    public List<Cidade> listar(){
    	return this.cidadeService.listarTodos();
    }
}
