
package br.unicesumar.escoladeti.controller;

import br.unicesumar.escoladeti.entity.Distrito;
import br.unicesumar.escoladeti.service.DistritoService;
import java.io.Serializable;
import static javax.management.Query.value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rest/distritoSource")
public class DistritoController implements Serializable {
    private static final long serialVersionUID = 1L;
    @Autowired
    private DistritoService distritoService;
    
    @RequestMapping(value = "/distrito", method = RequestMethod.POST)
    @ResponseBody
    public Distrito salvar(@RequestBody Distrito distrito){
        return this.distritoService.salvar(distrito);
    }
    
    @RequestMapping(value = "/distrito", method = RequestMethod.PUT)
    @ResponseBody
    public Distrito editar(@RequestBody Distrito distrito){
        Distrito distritoEditado = this.distritoService.getById(distrito.getId());
        System.out.println("Distrito " + distrito.getId());
        return distritoService.salvar(distritoEditado);
    }
    
    @RequestMapping(value = "/distrito/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Distrito getById(@PathVariable Long id){
        return this.distritoService.getById(id);
    }
    
    @RequestMapping(value = "/distrito", method = RequestMethod.GET)
    @ResponseBody
    public DataPage<Distrito> getTodos(){
        return distritoService.getTodos(1);
    }
    
    /*@RequestMapping(value = "/distrito", params = {"q"}, method = RequestMethod.GET)
    @ResponseBody
    public DataPage<Distrito> getPorNome(@RequestParam String q){
        return distritoService.getDistritoPorNome(q);
    }*/
    
    @RequestMapping(value = { "/listar/pag/{pagina}" }, method = RequestMethod.GET)
    @ResponseBody
    public DataPage<Distrito> listarDistrito(@PathVariable Integer pagina){
        return distritoService.getTodos(pagina);
    }
    
    @RequestMapping(value = "/distrito", method = RequestMethod.DELETE)
    @ResponseBody
    public String deletar(@RequestBody Distrito distrito){
        distritoService.deletar(distrito);
        return "deleted";
    }
  
}
