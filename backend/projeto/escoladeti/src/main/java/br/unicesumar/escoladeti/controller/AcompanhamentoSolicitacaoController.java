package br.unicesumar.escoladeti.controller;

import br.unicesumar.escoladeti.dto.AcompanhamentoDTO;
import br.unicesumar.escoladeti.pesquisa.PesquisaSolicitacao;
import br.unicesumar.escoladeti.service.AcompanhamentoSolicitacaoService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rest/acompanhamentosolicitacoes")
public class AcompanhamentoSolicitacaoController{
	
    @Autowired
    private AcompanhamentoSolicitacaoService acompanhamentosolicitacaoService;	

    @RequestMapping( method = RequestMethod.POST, value = "/listarPesquisa")	
    @ResponseBody
    public PesquisaSolicitacao listarPesquisa(@Valid @RequestBody PesquisaSolicitacao pesquisa) {		
        return pesquisa;//acompanhamentosolicitacaoService.listarItens(pesquisa);
    }
    
    @RequestMapping( method = RequestMethod.GET, value = "/listarItens")
    @ResponseBody
    public List<AcompanhamentoDTO> listarItens(){
        PesquisaSolicitacao ps = new PesquisaSolicitacao();
        ps.setStatus("CANCELADO");
        return acompanhamentosolicitacaoService.listarItens(ps);
    }

}