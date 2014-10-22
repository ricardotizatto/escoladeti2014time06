package br.unicesumar.escoladeti.controller;

import br.unicesumar.escoladeti.entity.Evento;
import br.unicesumar.escoladeti.service.MaterialStatusService;
import br.unicesumar.escoladeti.view.ViewMaterialProduzido;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class ExternoController {
    
    @Autowired
    private MaterialStatusService materialStatusService;

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
    
    @RequestMapping(value = "public/rest/materiaisproduzidos", method = RequestMethod.GET)
    @ResponseBody
    public List<ViewMaterialProduzido> listarMateriaisProduzidos() {
        return this.materialStatusService.listarMateriaisProduzidos();
    }

}
