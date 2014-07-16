package br.unicesumar.escoladeti.controller;

import br.unicesumar.escoladeti.entity.Pais;
import br.unicesumar.escoladeti.entity.UnidadeFederativa;
import br.unicesumar.escoladeti.service.UnidadeFederativaService;

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
@RequestMapping(value="/rest/unidadeFederativaSource")
public class UnidadeFederativaController implements Serializable{
    private static final long serialVersionUID = 1L;
    @Autowired
    private UnidadeFederativaService federativaService;

    @RequestMapping(value="/unidadeFederativa", method= RequestMethod.POST)
    @ResponseBody
    public UnidadeFederativa salvar(@RequestBody UnidadeFederativa unidadeFederativa) throws Exception {
            return this.federativaService.salvar(unidadeFederativa);
    }

    @RequestMapping(value="/unidadeFederativa", method= RequestMethod.DELETE)
    @ResponseBody
    public String deletar(@RequestBody UnidadeFederativa unidadeFederativa) {
        federativaService.deletar(unidadeFederativa);
        return "arquivo deletado";		
    }

    @RequestMapping(value = "/unidadeFederativa", params = {"q"}, method = RequestMethod.GET)
    @ResponseBody
    public DataPage<UnidadeFederativa> getPorNome(@RequestParam String q) {
        return federativaService.getUnidadesFederativasPorNome(q);
    }

    @RequestMapping(value = {"/listar/pag/{pagina}"}, method = RequestMethod.GET)
    @ResponseBody
    public DataPage<UnidadeFederativa> listarUnidadesFederativas(@PathVariable Integer pagina) {
        return federativaService.getTodos(pagina);
    }
    
    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    @ResponseBody
    public List<UnidadeFederativa> listaTodos() {
        return federativaService.listaTodos();
    }

    @RequestMapping(value= "/unidadeFederativa/{id}", method= RequestMethod.GET)
    @ResponseBody
    public UnidadeFederativa findById(@PathVariable Long id) {
        return this.federativaService.getById(id);
    }
    @RequestMapping(value="/listarPorPais/{idPais}",method = RequestMethod.GET)
    @ResponseBody
    public List<UnidadeFederativa> listaPorPais(@PathVariable Long idPais){
    	return this.federativaService.buscarUnidadeFederativaPorIdDoPais(idPais);
    }
}
