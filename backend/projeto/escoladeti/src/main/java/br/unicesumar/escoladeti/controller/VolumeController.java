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


    @RequestMapping( method = RequestMethod.POST)
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

    @RequestMapping(value = "/{id}/impresso", method = RequestMethod.PUT)
    public @ResponseBody Volume marcarComoImpresso(
            @PathVariable("id") Long idVolume,
            @RequestBody ComandoAlterarData comandoAlterarData) {
        return volumeService.marcarComoImprimido(idVolume, comandoAlterarData);
    }

    @RequestMapping(value = "/{id}/rejeitado", method = RequestMethod.PUT)
    public @ResponseBody Volume marcarComoRejeitado(
            @PathVariable("id") Long idVolume,
            @RequestBody ComandoMarcarRevisado comando) {
        return volumeService.rejeitar(idVolume, comando);
    }

    @RequestMapping(value = "/{id}/revisado", method = RequestMethod.PUT)
    public @ResponseBody Volume marcarComoRevisado(
            @PathVariable("id") Long idVolume,
            @RequestBody ComandoMarcarRevisado comando) {
        return volumeService.marcarComoRevisado(idVolume, comando);
    }

    @RequestMapping(value = "/{id}/enviado", method = RequestMethod.PUT)
    public @ResponseBody Volume marcarComoEnviado(
            @PathVariable("id") Long idVolume,
            @RequestBody ComandoAlterarData comando) {
        return volumeService.marcarComoEnviado(idVolume, comando);
    }

    @RequestMapping(value = "/{id}/andamento", method = RequestMethod.PUT)
    public @ResponseBody Volume reativar(
            @PathVariable("id") Long idVolume) {
        return volumeService.reativar(idVolume);
    }

}

