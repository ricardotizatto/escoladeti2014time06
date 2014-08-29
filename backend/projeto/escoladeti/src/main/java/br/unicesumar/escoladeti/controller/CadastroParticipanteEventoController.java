package br.unicesumar.escoladeti.controller;

import br.unicesumar.escoladeti.entity.Evento;
import br.unicesumar.escoladeti.service.EventoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CadastroParticipanteEventoController {
    @Autowired
    private EventoService eventoService;
    
    @RequestMapping(value = "/cadastroparticipanteevento", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
    @Transactional
    public ModelAndView CadastroParticipanteEvento() {
        //usuarioService.inicializarUsuarioAdmin();
        return new ModelAndView("public/cadastroparticipanteevento");
    }
    
    @RequestMapping(value = "./eventos", method = RequestMethod.GET)
    @ResponseBody
    public DataPage<Evento> getTodos() {
        return eventoService.getTodos(1);
    }
}
