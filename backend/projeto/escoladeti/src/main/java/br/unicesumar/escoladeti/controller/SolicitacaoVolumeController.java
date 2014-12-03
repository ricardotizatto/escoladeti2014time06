package br.unicesumar.escoladeti.controller;

import br.unicesumar.escoladeti.comando.ComandoSalvarSolicitacaoVolume;
import br.unicesumar.escoladeti.entity.SolicitacaoVolume;
import br.unicesumar.escoladeti.service.SolicitacaoVolumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Jhonatan on 02/12/2014.
 */
@Controller
@RequestMapping("/rest/solicitacoes-volume")
public class SolicitacaoVolumeController {

    @Autowired
    private SolicitacaoVolumeService solicitacaoVolumeService;


    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    SolicitacaoVolume criar(@RequestBody ComandoSalvarSolicitacaoVolume comandoSalvarSolicitacaoVolume) {
        return solicitacaoVolumeService.criar(comandoSalvarSolicitacaoVolume);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public @ResponseBody
    SolicitacaoVolume atualizar(@RequestBody ComandoSalvarSolicitacaoVolume comandoSalvarSolicitacaoVolume,
                                @PathVariable Long id) {
        return solicitacaoVolumeService.atualizar(id, comandoSalvarSolicitacaoVolume);
    }


    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public @ResponseBody String deletar(@PathVariable Long id) {
        solicitacaoVolumeService.deletar(id);
        return  "ok";
    }

    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public @ResponseBody SolicitacaoVolume buscar(@PathVariable Long id) {
        return solicitacaoVolumeService.buscar(id);
    }
}
