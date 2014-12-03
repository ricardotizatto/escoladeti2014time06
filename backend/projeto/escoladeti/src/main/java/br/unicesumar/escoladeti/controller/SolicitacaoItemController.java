package br.unicesumar.escoladeti.controller;

import br.unicesumar.escoladeti.comando.ComandoAlterarData;
import br.unicesumar.escoladeti.comando.ComandoSalvarVolume;
import br.unicesumar.escoladeti.entity.SolicitacaoItem;
import br.unicesumar.escoladeti.entity.SolicitacaoVolume;
import br.unicesumar.escoladeti.entity.Volume;
import br.unicesumar.escoladeti.enums.Transcricao;
import br.unicesumar.escoladeti.pesquisa.PesquisaSolicitacao;
import br.unicesumar.escoladeti.service.AcompanhamentoSolicitacaoService;
import br.unicesumar.escoladeti.service.SolicitacaoItemService;
import br.unicesumar.escoladeti.service.SolicitacaoVolumeService;
import br.unicesumar.escoladeti.service.VolumeService;
import br.unicesumar.escoladeti.view.ViewAcompanhamentoSolicitacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping(value = "/rest/solicitacao-itens")
public class SolicitacaoItemController {

    @Autowired
    private AcompanhamentoSolicitacaoService acompanhamentosolicitacaoService;

    @Autowired
    private SolicitacaoItemService solicitacaoItemService;

    @Autowired
    private SolicitacaoVolumeService solicitacaoVolumeService;


    @RequestMapping(value = "/{id}/cancelar", method = RequestMethod.POST)
    public @ResponseBody ViewAcompanhamentoSolicitacao cancelar(@PathVariable("id") Long id) {
        return solicitacaoItemService.cancelarItem(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody SolicitacaoItem buscar(@PathVariable("id") Long id) {
        return solicitacaoItemService.buscarItem(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<ViewAcompanhamentoSolicitacao> listarItensFiltrados(
            @RequestParam(value = "solicitacaoId", required = false) Long solicitacaoId,
            @RequestParam(value = "dataChegadaInicio", required = false) String dataChegadaInicio,
            @RequestParam(value = "dataChegadaFim", required = false) String dataChegadaFim,
            @RequestParam(value = "status", required = false) String status,
            @RequestParam(value = "traducaoMaterial", required = false) String traducaoMaterial,
            @RequestParam(value = "responsavel", required = false) String responsavel,
            @RequestParam(value = "material", required = false) String material,
            @RequestParam(value = "revisor", required = false) String revisor) {
        PesquisaSolicitacao ps = new PesquisaSolicitacao();
        ps.setSolicitacaoId(solicitacaoId);
        ps.setDataChegadaInicio(dataChegadaInicio);
        ps.setDataChegadaFim(dataChegadaFim);
        ps.setStatus(status);
        ps.setTraducaoMaterial(traducaoMaterial);
        ps.setResponsavel(responsavel);
        ps.setMaterial(material);
        ps.setRevisor(revisor);
        return acompanhamentosolicitacaoService.listarItensFiltrados(ps);
    }

    @RequestMapping(value = "/{id}/sugestao", method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Integer> sugerir(
            @PathVariable("id") Long idLivro,
            @RequestParam("transcricao") String trancricao) {
        return solicitacaoItemService.sugerirPagina(idLivro, Transcricao.of(trancricao));
    }

    @RequestMapping(value = "/{id}/finalizacao", method = RequestMethod.POST)
    public @ResponseBody SolicitacaoItem finalizar(
            @PathVariable("id") Long idSolicitacaoItem) {
        return solicitacaoItemService.finalizar(idSolicitacaoItem);
    }


    @RequestMapping(value = "/solicitacao-volume/impresso", method = RequestMethod.PUT)
    public @ResponseBody String marcarComoImpresso(
            @RequestBody List<ComandoAlterarData> comandos) {
         solicitacaoVolumeService.marcarComoImpresso( comandos);
        return "ok";
    }

    @RequestMapping(value = "/solicitacao-volume/rejeitado", method = RequestMethod.PUT)
    public @ResponseBody String rejeitar(
            @RequestBody List<ComandoAlterarData> comandos) {
        solicitacaoVolumeService.rejeitar( comandos);
        return "ok";
    }

    @RequestMapping(value = "/solicitacao-volume/revisado", method = RequestMethod.PUT)
    public @ResponseBody String marcarComoRevisado(
            @RequestBody List<ComandoAlterarData> comandos) {
        solicitacaoVolumeService.marcarComoRevisado(comandos);
        return "ok";
    }


    @RequestMapping(value = "/solicitacao-volume/reativacao", method = RequestMethod.PUT)
    public @ResponseBody String reativar(
            @RequestBody List<ComandoAlterarData> comandos) {
        solicitacaoVolumeService.reativar(comandos);
        return "ok";
    }

    @RequestMapping(value = "/solicitacao-volume/enviado", method = RequestMethod.PUT)
    public @ResponseBody String marcarComoEnviado(
            @RequestBody List<ComandoAlterarData> comandos) {
        solicitacaoVolumeService.marcarComoEnviado(comandos);
        return "ok";
    }
}
