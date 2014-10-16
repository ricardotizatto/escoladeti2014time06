package br.unicesumar.escoladeti.controller;

import br.unicesumar.escoladeti.entity.Evento;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jhonatan on 15/10/2014.
 */
@Controller
public class ExternoController {

    @RequestMapping(value = "/externo", method = {RequestMethod.GET})
    @Transactional
    public ModelAndView login() {
        return new ModelAndView("public/externo");
    }


    @RequestMapping(value = "public/rest/eventos", method = RequestMethod.GET)
    @ResponseBody
    public List<Evento> listarEventos() {
        Evento evento = new Evento();

        evento.setDescricao("festa do martinho");


        ArrayList<Evento> testes = new ArrayList<Evento>();
        testes.add(evento);

        evento = new Evento();

        evento.setDescricao("asdfasdf");
        testes.add(evento);


        return testes;
    }

}
