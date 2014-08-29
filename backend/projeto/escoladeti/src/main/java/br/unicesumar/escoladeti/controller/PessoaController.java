package br.unicesumar.escoladeti.controller;

import br.unicesumar.escoladeti.comando.ComandoSalvarPessoa;
import br.unicesumar.escoladeti.entity.Pessoa;
import br.unicesumar.escoladeti.entity.PessoaFisica;
import br.unicesumar.escoladeti.entity.PessoaJuridica;
import br.unicesumar.escoladeti.service.PessoaService;
import java.io.Serializable;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rest/pessoas")
public class PessoaController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private PessoaService pessoaService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Pessoa salvar(@Valid @RequestBody ComandoSalvarPessoa comando) {
        return pessoaService.persistirPessoa(comando, null);
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.PUT)
    @ResponseBody
    public Pessoa atualizar(@Valid @RequestBody ComandoSalvarPessoa comando, @PathVariable("id")Long id) {
        return pessoaService.persistirPessoa(comando, id);
    }
    
    @RequestMapping(value = {"/{id}/{tipo}"}, method = RequestMethod.DELETE )
    @ResponseBody
    public void deletar(@PathVariable Long id, @PathVariable String tipo) {
        pessoaService.deletarPessoa(id, tipo);
    }

    @RequestMapping(value = {"/{id}/{tipo}"}, method = RequestMethod.GET)
    @ResponseBody
    public Pessoa getPessoa(@PathVariable Long id, @PathVariable String tipo) {
        return pessoaService.buscar(id, tipo);
    }

    @RequestMapping(value = {"/paginarFisica/{pagina}"}, method = RequestMethod.GET)
    @ResponseBody
    public DataPage<PessoaFisica> paginarFisica(@PathVariable Integer pagina) {
        return pessoaService.paginarFisica(pagina);
    }

    @RequestMapping(value = {"/buscarFisica/{pagina}/{busca}"}, method = RequestMethod.GET)
    @ResponseBody
    public DataPage<PessoaFisica> buscarFisica(@PathVariable Integer pagina, @PathVariable String busca) {
        return pessoaService.buscarFisica(pagina, busca);
    }

    @RequestMapping(value = {"/paginarAluno/{pagina}"}, method = RequestMethod.GET)
    @ResponseBody
    public DataPage<PessoaFisica> paginarAluno(@PathVariable Integer pagina) {
        return pessoaService.paginarAluno(pagina);
    }

    @RequestMapping(value = {"/buscarAluno/{pagina}/{busca}"}, method = RequestMethod.GET)
    @ResponseBody
    public DataPage<PessoaFisica> buscarAluno(@PathVariable Integer pagina, @PathVariable String busca) {
        return pessoaService.buscarAluno(pagina, busca);
    }

    @RequestMapping(value = {"/paginarJuridica/{pagina}"}, method = RequestMethod.GET)
    @ResponseBody
    public DataPage<PessoaJuridica> paginarJuridica(@PathVariable Integer pagina) {
        return pessoaService.paginarJuridica(pagina);
    }

    @RequestMapping(value = {"/buscarJuridica/{pagina}/{busca}"}, method = RequestMethod.GET)
    @ResponseBody
    public DataPage<PessoaJuridica> buscarJuridica(@PathVariable Integer pagina, @PathVariable String busca) {
        return pessoaService.buscarJuridica(pagina, busca);
    }
}
