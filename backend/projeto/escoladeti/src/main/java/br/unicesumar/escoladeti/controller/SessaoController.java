package br.unicesumar.escoladeti.controller;

import br.unicesumar.escoladeti.application.Sessao;
import br.unicesumar.escoladeti.entity.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Jhonatan on 24/11/2014.
 */
@RequestMapping("/rest/sessao")
@Controller
public class SessaoController {

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody UserDetails getUsuario() {
        UserDetails userDetails = Sessao.currentUserDetails();
        return userDetails;
    }
}
