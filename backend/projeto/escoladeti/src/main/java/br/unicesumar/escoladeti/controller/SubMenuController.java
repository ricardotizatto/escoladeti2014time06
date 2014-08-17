package br.unicesumar.escoladeti.controller;

import br.unicesumar.escoladeti.entity.SubMenu;
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
@RequestMapping("/rest/subMenuSource")
public class SubMenuController implements Serializable {
    private static final long serialVersionUID = 1L;
    @Autowired
    private SubMenuService subMenuService;
    
    
    @RequestMapping(value= "/subMenu", method = RequestMethod.POST)
    @ResponseBody
    public SubMenu salvar(@RequestBody SubMenu subMenu){
        return subMenuService.salvar(subMenu);
    }
    
    @RequestMapping(value="/subMenu/{id}", method = RequestMethod.GET)
    @ResponseBody
    public SubMenu getById(@PathVariable Long id){
        return subMenuService.getById(id);
    }
    
    @RequestMapping(value="/subMenu", method = RequestMethod.GET)
    @ResponseBody
    public List<SubMenu> getTodos(){
        return subMenuService.getTodos();
    }
    
    @RequestMapping(value="/subMenu", method = RequestMethod.DELETE)
    @ResponseBody
    public String deletar(@RequestBody SubMenu subMenu){
        subMenuService.deletar(subMenu);
        return "deleted";
    }
}
