package br.unicesumar.escoladeti.controller;

import br.unicesumar.escoladeti.entity.OrdemProducao;
import br.unicesumar.escoladeti.entity.Pais;
import br.unicesumar.escoladeti.entity.ParteMaterial;
import br.unicesumar.escoladeti.service.OrdemProducaoService;
import br.unicesumar.escoladeti.service.PaisService;
import br.unicesumar.escoladeti.service.ParteMaterialService;
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
@RequestMapping("/rest/ordemProducaoSource")
public class OrdemProducaoController implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Autowired
    private OrdemProducaoService ordemProducaoService;
    
    @Autowired
    private ParteMaterialService parteMaterialService;

    @RequestMapping(value = "/ordemProducao", method = RequestMethod.POST)
    @ResponseBody
    public OrdemProducao salvar(@RequestBody OrdemProducao ordemProducao) {
        return ordemProducaoService.salvar(ordemProducao);
    }

    @RequestMapping(value = "/ordemProducao", method = RequestMethod.PUT)
    @ResponseBody
    public OrdemProducao editar(@RequestBody OrdemProducao ordemProducao) {
        OrdemProducao ordemProducaoEditada = this.ordemProducaoService.getById(ordemProducao.getId());
        return ordemProducaoService.salvar(ordemProducaoEditada);
    }

    @RequestMapping(value = "/ordemProducao/{id}", method = RequestMethod.GET)
    @ResponseBody
    public OrdemProducao getById(@PathVariable Long id) {
        return ordemProducaoService.getById(id);
    }

    @RequestMapping(value = "/ordemProducao", method = RequestMethod.GET)
    @ResponseBody
    public DataPage<OrdemProducao> getTodos() {
        return ordemProducaoService.getTodos(1);
    }

    @RequestMapping(value = {"/listar/pag/{pagina}"}, method = RequestMethod.GET)
    @ResponseBody
    public DataPage<OrdemProducao> listarOrdemProducao(@PathVariable Integer pagina) {
        return ordemProducaoService.getTodos(pagina);
    }

    @RequestMapping(value = "/ordemProducao", method = RequestMethod.DELETE)
    @ResponseBody
    public String deletar(@RequestBody OrdemProducao ordemProducao) {
        ordemProducaoService.deletar(ordemProducao);
        return "deleted";
    }
    
    //
    //ParteMaterial
    //
    @RequestMapping(value = "/parteMaterial", method = RequestMethod.POST)
    @ResponseBody
    public ParteMaterial salvarParteMaterial(@RequestBody ParteMaterial parteMaterial) {
        return this.parteMaterialService.salvar(parteMaterial);
    }

    @RequestMapping(value = "/parteMaterial", method = RequestMethod.GET)
    @ResponseBody
    public List<ParteMaterial> getTodasPartesMateriais() {
        return this.parteMaterialService.getTodos();
    }

    @RequestMapping(value = "/parteMaterial/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ParteMaterial getParteMaterialById(@PathVariable Long id) {
        return this.parteMaterialService.getById(id);
    }

    @RequestMapping(value = "/parteMaterial", method = RequestMethod.DELETE)
    @ResponseBody
    public String deletar(@RequestBody ParteMaterial parteMaterial) {
        this.parteMaterialService.remover(parteMaterial);
        return "deleted";
    }
}
