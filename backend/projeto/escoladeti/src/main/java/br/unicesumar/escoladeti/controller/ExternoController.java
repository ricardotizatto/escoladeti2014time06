package br.unicesumar.escoladeti.controller;

import br.unicesumar.escoladeti.entity.Evento;
import br.unicesumar.escoladeti.entity.Livro;
import br.unicesumar.escoladeti.entity.Participante;
import br.unicesumar.escoladeti.entity.Periodo;
import br.unicesumar.escoladeti.service.EventoService;
import br.unicesumar.escoladeti.service.LivroService;
import br.unicesumar.escoladeti.service.ParticipanteService;
import br.unicesumar.escoladeti.service.PeriodoEventoService;
import br.unicesumar.escoladeti.service.PeriodoService;
import br.unicesumar.escoladeti.view.ViewPeriodoEvento;
import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExternoController implements Serializable{
              
    @Autowired
    private LivroService livroService;
    
    @Autowired
    private EventoService eventoService;
    
    @Autowired
    private PeriodoService periodoService;
    
    @Autowired
    private PeriodoEventoService periodoeventoService;
    
    @Autowired
    private ParticipanteService participanteService;

    @RequestMapping(value = "/externo", method = {RequestMethod.GET})
    @Transactional
    public ModelAndView login() {
        return new ModelAndView("public/externo");
    }

    @RequestMapping(value = {"public/rest/salvarparticipante/"}, method = RequestMethod.POST)
    @ResponseBody
    public Participante salvarParticipante(@RequestBody Participante participante) {
        return this.participanteService.salvar(participante);
    }
    
    @RequestMapping(value = {"public/rest/livrostranscritos/pag/{pagina}"}, method = RequestMethod.GET)
    @ResponseBody
    public DataPage<Livro> listarLivrosTranscritos(@PathVariable Integer pagina) {
        return this.livroService.listarLivrosTranscritos(pagina);
    }
           
    @RequestMapping(value = "public/rest/buscalivrostranscritos", params = {"q"}, method = RequestMethod.GET)
    @ResponseBody
    public DataPage<Livro> buscaMateriaisProduzidos(@RequestParam String q) {
        return this.livroService.getLivroPorNome(q);
    }
    
    @RequestMapping(value = "public/rest/eventos/pag/{pagina}", method = RequestMethod.GET)
    @ResponseBody
    public DataPage<Evento> getTodos(@PathVariable Integer pagina) {
        return eventoService.getTodos(pagina);
    }
    
    
    @RequestMapping(value = "public/rest/proximoseventos/{pagina}", method = RequestMethod.GET)
    @ResponseBody
    public DataPage<ViewPeriodoEvento> getProximosEventos(@PathVariable Integer pagina) {
        return periodoeventoService.getProximosEventos(pagina);
    }
    
    @RequestMapping(value = "public/rest/ultimoseventos/{pagina}", method = RequestMethod.GET)
    @ResponseBody
    public DataPage<ViewPeriodoEvento> getUltimosEventos(@PathVariable Integer pagina) {
        return periodoeventoService.getUltimosEventos(pagina);
    }
    
    @RequestMapping(value = "public/rest/ultimosperiodos", method = RequestMethod.GET)
    @ResponseBody
    public DataPage<Periodo> listarUltimosPeriodos() {
        return periodoService.listarUltimosPeriodos();
    }
    
    @RequestMapping(value = "public/rest/evento/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Evento getEvento(@PathVariable Long id) {
         return eventoService.getById(id);
    }

}
