package br.unicesumar.escoladeti.controller;

import br.unicesumar.escoladeti.dto.AcompanhamentoDTO;
import br.unicesumar.escoladeti.entity.SolicitacaoItem;
import br.unicesumar.escoladeti.service.AcompanhamentoSolicitacaoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rest/acompanhamentosolicitacoes")
public class AcompanhamentoSolicitacaoController{
	
    @Autowired
    private AcompanhamentoSolicitacaoService acompanhamentosolicitacaoService;	

    @RequestMapping(value = { "/listar" }, method = RequestMethod.GET)
    @ResponseBody
    public List<AcompanhamentoDTO> listar() {
            return acompanhamentosolicitacaoService.listar() ;
    }
	
}