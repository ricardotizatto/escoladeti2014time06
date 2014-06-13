package br.unicesumar.escoladeti.controller;

import br.unicesumar.escoladeti.entity.Participante;
import br.unicesumar.escoladeti.service.ParticipanteService;
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
@RequestMapping("/rest/participanteSource")
public class ParticipanteController implements Serializable {
    private static final long serialVersionUID = 1L;
    @Autowired
    private ParticipanteService participanteService;
    
    @RequestMapping(value= "/participante", method = RequestMethod.POST)
    @ResponseBody
    public Participante salvar(@RequestBody Participante participante){
        return this.participanteService.salvar(participante);
    }
    
    @RequestMapping(value="/participante/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Participante getById(@PathVariable Long id){
        System.out.println("buscando por id:");
        return participanteService.getById(id);
    }
    
    @RequestMapping(value="/participante", method = RequestMethod.GET)
    @ResponseBody
    public List<Participante> getTodos(){
        System.out.println("buscando geral:");
        return participanteService.getTodos();
    }
    
    @RequestMapping(value="/listaparticipantes/{idevento}", method = RequestMethod.GET)
    @ResponseBody
    public List<Participante> getByIdevento(@PathVariable Long idevento){
        System.out.println("buscando por id:" +idevento);
        return participanteService.getByIdevento(idevento);
    }
        
    
    @RequestMapping(value="/participante", method = RequestMethod.DELETE)
    @ResponseBody
    public String deletar(@RequestBody Participante participante){
        participanteService.deletar(participante);
        return "deleted";
    }
}