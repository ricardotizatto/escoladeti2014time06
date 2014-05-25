package br.unicesumar.escoladeti.controller;

import br.unicesumar.escoladeti.entity.Evento;
import br.unicesumar.escoladeti.service.EventoService;
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
@RequestMapping("/rest/eventoSource")
public class EventoController implements Serializable {
    private static final long serialVersionUID = 1L;
    @Autowired
    private EventoService eventoService;
    
    @RequestMapping(value= "/evento", method = RequestMethod.POST)
    @ResponseBody
    public Evento salvar(@RequestBody Evento evento){
        return this.eventoService.salvar(evento);
    }
    
    @RequestMapping(value="/evento/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Evento getById(@PathVariable Long id){
        return eventoService.getById(id);
    }
    
    @RequestMapping(value="/evento", method = RequestMethod.GET)
    @ResponseBody
    public List<Evento> getTodos(){
        return eventoService.getTodos();
    }
    
    @RequestMapping(value="/evento", method = RequestMethod.DELETE)
    @ResponseBody
    public String deletar(@RequestBody Evento evento){
        eventoService.deletar(evento);
        return "deleted";
    }
}
