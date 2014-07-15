package br.unicesumar.escoladeti.controller;

import br.unicesumar.escoladeti.entity.Livro;
import br.unicesumar.escoladeti.service.LivroService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConsultaLivroController {
    @Autowired
    private LivroService livroService;
    
    @RequestMapping(value = "/consultalivro", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
    @Transactional
    public ModelAndView CadastroParticipanteEvento() {
        //usuarioService.inicializarUsuarioAdmin();
        return new ModelAndView("public/consultalivro");
    }
    
    @RequestMapping(value = "./livros", method = RequestMethod.GET)
    @ResponseBody
    public List<Livro> getTodos() {
        return livroService.getTodos();
    }
}
