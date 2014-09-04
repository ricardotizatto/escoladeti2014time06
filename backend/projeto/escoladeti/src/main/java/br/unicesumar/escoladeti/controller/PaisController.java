package br.unicesumar.escoladeti.controller;

import br.unicesumar.escoladeti.entity.Pais;
import br.unicesumar.escoladeti.service.PaisService;
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
@RequestMapping("/rest/paisSource")
public class PaisController implements Serializable {

	@RequestMapping(value = "/pais", method = RequestMethod.POST)
	@ResponseBody
	public Pais salvar(@RequestBody Pais pais) throws Exception  {
            if (!pais.equals(paisService.buscarPaisPorNomeSiglaCodigo(pais))) {
            return this.paisService.salvar(pais);
        }
        throw new Exception("O País " + pais.getNome() + " já está cadastrado!");
    }

    @RequestMapping(value = "/pais", method = RequestMethod.POST)
    @ResponseBody
    public Pais salvar(@RequestBody Pais pais) {
        return paisService.salvar(pais);
    }

    @RequestMapping(value = "/pais", method = RequestMethod.PUT)
    @ResponseBody
    public Pais editar(@RequestBody Pais pais) {
        Pais paisEditado = this.paisService.getById(pais.getId());
        System.out.println("Pais " + pais.getId());
        return paisService.salvar(paisEditado);
    }

    @RequestMapping(value = "/pais/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Pais getById(@PathVariable Long id) {
        return paisService.getById(id);
    }

    

    @RequestMapping(value = "/pais", method = RequestMethod.GET)
    @ResponseBody
    public DataPage<Pais> getTodos() {
        return paisService.getTodos(1);
    }

    

    @RequestMapping(value = {"/listar/pag/{pagina}"}, method = RequestMethod.GET)
    @ResponseBody
    public DataPage<Pais> listarPais(@PathVariable Integer pagina) {
        return paisService.getTodos(pagina);
    }

    @RequestMapping(value = "/pais", method = RequestMethod.DELETE)
    @ResponseBody
    public String deletar(@RequestBody Pais pais) {
        paisService.deletar(pais);
        return "deleted";
    }

}
