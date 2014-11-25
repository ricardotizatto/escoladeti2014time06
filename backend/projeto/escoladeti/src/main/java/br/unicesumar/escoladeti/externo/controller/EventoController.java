package br.unicesumar.escoladeti.externo.controller;

import br.unicesumar.escoladeti.controller.DataPage;
import br.unicesumar.escoladeti.entity.Evento;
import br.unicesumar.escoladeti.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Jhonatan on 15/10/2014.
 */

@RequestMapping(value = "/public/rest/eventos")
public class EventoController {


    @Autowired
    private EventoService eventoService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public DataPage<Evento> listarEventos() {
        return eventoService.getTodos(1);
    }
}
