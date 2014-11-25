package br.unicesumar.escoladeti.controller;

import br.unicesumar.escoladeti.comando.ComandoSalvarMovimentacao;
import br.unicesumar.escoladeti.entity.Movimentacao;
import br.unicesumar.escoladeti.service.MovimentacaoService;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rest/movimentacaoSource")
public class MovimentacaoController implements Serializable {

    @Autowired
    private MovimentacaoService movimentacaoService;

    @RequestMapping(value = "/movimentacao", method = RequestMethod.POST)
    @ResponseBody
    public Movimentacao salvar(@RequestBody ComandoSalvarMovimentacao comando) throws Exception {
        return this.movimentacaoService.salvar(comando);
    }
    
    @RequestMapping(value = "/extornar/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Movimentacao extornar(@PathVariable Long id) throws Exception {
        return this.movimentacaoService.extornar(id);
    }

    @RequestMapping(value = {"/paginar/{pagina}"}, method = RequestMethod.GET)
    @ResponseBody
    public DataPage<Movimentacao> listarMovimentacao(@PathVariable Integer pagina) {
        return movimentacaoService.getTodos(pagina);
    }

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    @ResponseBody
    public List<Movimentacao> listaTodos() {
        return movimentacaoService.listaTodos();
    }

    @RequestMapping(value = "/movimentacao/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Movimentacao findById(@PathVariable Long id) {
        return this.movimentacaoService.getById(id);
    }

    @RequestMapping(value = "/movimentacao/", params = {"q"}, method = RequestMethod.GET)
    @ResponseBody
    public DataPage<Movimentacao> getPorNome(@RequestParam String q) {
        return movimentacaoService.getPorNome(q);
    }
}
