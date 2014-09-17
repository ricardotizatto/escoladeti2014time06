package br.unicesumar.escoladeti.controller;

import br.unicesumar.escoladeti.service.RelatorioParticipanteService;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/relatorio/participantes")
public class RelatorioParticipanteEventoController implements Serializable {

    @Autowired
    private RelatorioParticipanteService relatorioParticipanteService;
    
    @RequestMapping(value="/{idevento}", method = RequestMethod.GET)
    @ResponseBody
    public void imprimirRelatorio(@PathVariable Long idevento){
       relatorioParticipanteService.imprimirRelatorio(idevento);
       //TODO retornar pdf compilado e abrir em uma nova janela
    }

}
