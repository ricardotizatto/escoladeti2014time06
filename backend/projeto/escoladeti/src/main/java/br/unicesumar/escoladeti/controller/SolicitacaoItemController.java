package br.unicesumar.escoladeti.controller;

import br.unicesumar.escoladeti.comando.ComandoSalvarVolume;
import br.unicesumar.escoladeti.entity.SolicitacaoItem;
import br.unicesumar.escoladeti.entity.Volume;
import br.unicesumar.escoladeti.service.SolicitacaoItemService;
import br.unicesumar.escoladeti.service.VolumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Jhonatan on 16/09/2014.
 */
@Controller
@RequestMapping(value = "/rest/solicitacao-itens")
public class SolicitacaoItemController {

    @Autowired
    private SolicitacaoItemService solicitacaoItemService;

    @Autowired
    private VolumeService volumeService;

    @RequestMapping(value = "/{id}/produzir", method = RequestMethod.POST)
    public @ResponseBody SolicitacaoItem produzir(@PathVariable("id") Long id) {
        return solicitacaoItemService.enviarParaProducao(id);
    }

    @RequestMapping(value = "/{id}/cancelar", method = RequestMethod.POST)
    public @ResponseBody SolicitacaoItem cancelar(@PathVariable("id") Long id) {
        return solicitacaoItemService.cancelarItem(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody SolicitacaoItem buscar(@PathVariable("id") Long id) {
        return solicitacaoItemService.buscarItem(id);
    }

}
