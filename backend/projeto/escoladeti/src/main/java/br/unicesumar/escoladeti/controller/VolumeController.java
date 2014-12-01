package br.unicesumar.escoladeti.controller;

import br.unicesumar.escoladeti.comando.ComandoAlterarData;
import br.unicesumar.escoladeti.comando.ComandoMarcarRevisado;
import br.unicesumar.escoladeti.comando.ComandoSalvarVolume;
import br.unicesumar.escoladeti.entity.Volume;
import br.unicesumar.escoladeti.service.VolumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping(value = "/rest/volumes")
public class VolumeController {

    @Autowired
    private VolumeService volumeService;


    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    Volume novoVolume(
            @Valid @RequestBody ComandoSalvarVolume comandoSalvarVolume) {
        return volumeService.criarVolume(comandoSalvarVolume);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public @ResponseBody Volume atualizarVolume(
            @PathVariable("id") Long idVolume,
            @Valid @RequestBody ComandoSalvarVolume comandoSalvarVolume) {
        return volumeService.atualizarVolume(idVolume, comandoSalvarVolume);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody Volume buscar(
            @PathVariable("id") Long idVolume) {
        return volumeService.buscar(idVolume);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public @ResponseBody String deletar(
            @PathVariable("id") Long idVolume) {
        volumeService.deletar(idVolume);
        return "deletado";
    }


    @RequestMapping(value = "/{id}/reativacao", method = RequestMethod.PUT)
    public @ResponseBody Volume reativar(
            @PathVariable("id") Long idVolume) {
        return volumeService.reativar(idVolume);
    }

    @RequestMapping(value = "/{id}/conclusao", method = RequestMethod.PUT)
    public @ResponseBody Volume concluir(
            @PathVariable("id") Long idVolume,
            @RequestBody ComandoSalvarVolume comando) {
        return volumeService.concluir(idVolume, comando);
    }



}

