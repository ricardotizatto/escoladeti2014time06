
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
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rest/cidadeSource")
public class CidadeController implements Serializable {
    private static final long serialVersionUID = 1L;
    @Autowired
    private CidadeService cidadeService;
    
    @RequestMapping(value="/cidade", method = RequestMethod.POST)
    @ResponseBody
    public Cidade salvar(@RequestBody Cidade cidade){
        System.out.println(cidade.getFundacao());
        return cidadeService.salvar(cidade);
    }
    
    @RequestMapping(value="/cidade/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Cidade getById(@PathVariable Long id){
        return cidadeService.getById(id);
    }
    
    @RequestMapping(value="/cidade", method = RequestMethod.GET)
    @ResponseBody
    public List<Cidade> getTodos(){
        return cidadeService.getTodos();
    }
    
    @RequestMapping(value="/cidade", method = RequestMethod.DELETE)
    @ResponseBody
    public String deletar(@RequestBody Cidade cidade){
        cidadeService.deletar(cidade);
        return "deleted";
    }
}
