package br.unicesumar.escoladeti.controller;

import br.unicesumar.escoladeti.entity.ItemAcesso;
import br.unicesumar.escoladeti.entity.SubMenu;
import br.unicesumar.escoladeti.service.ItemAcessoService;
import br.unicesumar.escoladeti.service.SubMenuService;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rest/itemAcessoSource")
public class ItemAcessoController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private ItemAcessoService itemAcessoService;

    @RequestMapping(value = "/itemAcesso", method = RequestMethod.POST)
    @ResponseBody
    public ItemAcesso salvar(@RequestBody ItemAcesso itemAcesso) {
           return this.itemAcessoService.salvar(itemAcesso);
    }

    @RequestMapping(value = "/itemAcesso", method = RequestMethod.GET)
    @ResponseBody
    public List<ItemAcesso> getTodos() {
        return this.itemAcessoService.getTodos();
    }

    @RequestMapping(value = "/itemAcesso/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ItemAcesso getById(@PathVariable Long id) {
        return this.itemAcessoService.getById(id);
    }
    

    @RequestMapping(value = "/itemAcesso", method = RequestMethod.DELETE)
    @ResponseBody
    public String deletar(@RequestBody ItemAcesso itemAcesso) {
        this.itemAcessoService.deletar(itemAcesso);
        return "Deleted";
    }

}
