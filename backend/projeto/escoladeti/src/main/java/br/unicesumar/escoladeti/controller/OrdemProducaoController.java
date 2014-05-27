package br.unicesumar.escoladeti.controller;

import br.unicesumar.escoladeti.entity.OrdemProducao;
import br.unicesumar.escoladeti.service.OrdemProducaoService;
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
@RequestMapping("/rest/ordemProducaoSource")
public class OrdemProducaoController implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Autowired
    private OrdemProducaoService ordemProducaoService;
    
    @RequestMapping(value="/ordemproducao", method = RequestMethod.POST)
    @ResponseBody
    public OrdemProducao salvar(@RequestBody OrdemProducao ordemProducao){
        return ordemProducaoService.salvar(ordemProducao);
    }
    
    @RequestMapping(value="/ordemproducao", method = RequestMethod.GET)
    @ResponseBody
    public List<OrdemProducao> getTodos(){
        return ordemProducaoService.getTodos();
    }
    
    @RequestMapping(value="/ordemproducao/{id}", method = RequestMethod.GET)
    @ResponseBody
    public OrdemProducao getById(@PathVariable Long id){
        return ordemProducaoService.getById(id);
    }
    
    @RequestMapping(value="/ordemproducao", method = RequestMethod.DELETE)
    @ResponseBody
    public void deletar(@RequestBody OrdemProducao ordemProducao){
        ordemProducaoService.deletar(ordemProducao);
    }
}
