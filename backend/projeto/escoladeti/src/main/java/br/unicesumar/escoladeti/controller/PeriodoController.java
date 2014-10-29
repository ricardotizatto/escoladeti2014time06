package br.unicesumar.escoladeti.controller;

import br.unicesumar.escoladeti.entity.Periodo;
import br.unicesumar.escoladeti.service.PeriodoService;
import br.unicesumar.escoladeti.util.data.DateUtil;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rest/periodoSource")
public class PeriodoController implements Serializable {

    private static final long serialVersionUID = 1L;
    @Autowired
    private PeriodoService periodoService;

    @RequestMapping(value = "/periodo", method = RequestMethod.POST)
    @ResponseBody
    public Periodo salvar(@RequestBody Periodo periodo) throws Exception {
        return this.periodoService.salvar(periodo);
    }

    @RequestMapping(value = "/periodo/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Periodo getById(@PathVariable Long id) {
        return periodoService.getById(id);
    }

   /* @RequestMapping(value = "/periodo", method = RequestMethod.GET)
    @ResponseBody
    public DataPage<Periodo> getTodos() {
        return periodoService.getTodos(1);
    }

    @RequestMapping(value = {"/listar/pag/{pagina}"}, method = RequestMethod.GET)
    @ResponseBody
    public DataPage<Periodo> listarPeriodo(@PathVariable Integer pagina) {
        return periodoService.getTodos(pagina);
    }*/

    @RequestMapping(value = "/periodo", method = RequestMethod.DELETE)
    @ResponseBody
    public String deletar(@RequestBody Periodo periodo) {
        periodoService.deletar(periodo);
        return "deleted";
    }

    /*@RequestMapping(value = "/periodo", method = RequestMethod.PUT)
    @ResponseBody
    public Periodo editar(@RequestBody Periodo periodo) {
        Periodo periodoEditado = this.periodoService.getById(periodo.getId());
        System.out.println("Periodo " + periodo.getId());
        return periodoService.salvar(periodoEditado);
    }*/
}
