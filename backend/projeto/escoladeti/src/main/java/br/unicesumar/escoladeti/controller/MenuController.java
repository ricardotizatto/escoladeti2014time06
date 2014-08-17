package br.unicesumar.escoladeti.controller;

import br.unicesumar.escoladeti.entity.Menu;
import br.unicesumar.escoladeti.service.MenuService;
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
@RequestMapping("/rest/menuSource")
public class MenuController implements Serializable {
    private static final long serialVersionUID = 1L;
    @Autowired
    private MenuService menuService;
    
    @RequestMapping(value= "/menu", method = RequestMethod.POST)
    @ResponseBody
    public Menu salvar(@RequestBody Menu menu){
        return menuService.salvar(menu);
    }
    
    @RequestMapping(value="/menu/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Menu getById(@PathVariable Long id){
        return menuService.getById(id);
    }
    
    @RequestMapping(value="/menu", method = RequestMethod.GET)
    @ResponseBody
    public List<Menu> getTodos(){
        return menuService.getTodos();
    }
    
    @RequestMapping(value="/menu", method = RequestMethod.DELETE)
    @ResponseBody
    public String deletar(@RequestBody Menu menu){
        menuService.deletar(menu);
        return "deleted";
    }
}
