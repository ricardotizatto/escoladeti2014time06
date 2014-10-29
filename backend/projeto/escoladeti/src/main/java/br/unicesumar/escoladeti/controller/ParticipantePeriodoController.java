package br.unicesumar.escoladeti.controller;

import br.unicesumar.escoladeti.entity.Participante;
import br.unicesumar.escoladeti.entity.ParticipantePeriodo;
import br.unicesumar.escoladeti.service.ParticipantePeriodoService;
import br.unicesumar.escoladeti.service.ParticipanteService;
import br.unicesumar.escoladeti.service.RelatorioParticipanteService;
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
@RequestMapping("/rest/participanteperiodoSource")
public class ParticipantePeriodoController implements Serializable {

    private static final long serialVersionUID = 1L;
    @Autowired
    private ParticipantePeriodoService participantePeriodoService;

    @RequestMapping(value = "/participanteperiodo", method = RequestMethod.POST)
    @ResponseBody
    public ParticipantePeriodo salvar(@RequestBody ParticipantePeriodo participantePeriodo) {
        return this.participantePeriodoService.salvar(participantePeriodo);
    }

    @RequestMapping(value = "/participanteperiodo/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<ParticipantePeriodo> getById(@PathVariable Long id) {
        System.out.println("buscando por id:"+ id);
        return participantePeriodoService.listarParticipantesPorPeriodo(id);
    }

    @RequestMapping(value = "/participanteperiodo", method = RequestMethod.GET)
    @ResponseBody
    public List<ParticipantePeriodo> getTodos() {
        System.out.println("buscando geral:");
        return participantePeriodoService.getTodos();
    }

}
