package br.unicesumar.escoladeti.controller;

import br.unicesumar.escoladeti.entity.Evento;
import br.unicesumar.escoladeti.service.EventoService;
import br.unicesumar.escoladeti.service.MaterialStatusService;
import br.unicesumar.escoladeti.view.ViewMaterialProduzido;
import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExternoController implements Serializable{
    
    @Autowired
    private MaterialStatusService materialStatusService;
    
    @Autowired
    private EventoService eventoService;

    @RequestMapping(value = "/externo", method = {RequestMethod.GET})
    @Transactional
    public ModelAndView login() {
        return new ModelAndView("public/externo");
    }
    
    @RequestMapping(value = {"public/rest/materiaisproduzidos/pag/{pagina}"}, method = RequestMethod.GET)
    @ResponseBody
    public DataPage<ViewMaterialProduzido> listarMateriaisProduzidos(@PathVariable Integer pagina) {
        return this.materialStatusService.listarMateriaisProduzidos(pagina);
    }
       
    @RequestMapping(value = "public/rest/buscamateriaisproduzidos", params = {"q"}, method = RequestMethod.GET)
    @ResponseBody
    public DataPage<ViewMaterialProduzido> buscaMateriaisProduzidos(@RequestParam String q) {
        return this.materialStatusService.buscaMateriaisProduzidos(q);
    }
    
    @RequestMapping(value = "public/rest/eventos/pag/{pagina}", method = RequestMethod.GET)
    @ResponseBody
    public DataPage<Evento> getTodos(@PathVariable Integer pagina) {
        return eventoService.getTodos(pagina);
    }
    
    @RequestMapping(value = "public/rest/proximoseventos", method = RequestMethod.GET)
    @ResponseBody
    public DataPage<Evento> getProxomosEventos() {
        return eventoService.getProxomosEventos();
    }
    
    @RequestMapping(value = "public/rest/ultimoseventos", method = RequestMethod.GET)
    @ResponseBody
    public DataPage<Evento> getUltimosEventos() {
        return eventoService.getUltimosEventos();
    }
    
    @RequestMapping(value = "public/rest/evento/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Evento getEvento(@PathVariable Long id) {
         return eventoService.getById(id);
    }

}
