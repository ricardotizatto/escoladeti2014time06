package br.unicesumar.escoladeti.controller;

import br.unicesumar.escoladeti.comando.ComandoSalvarPessoa;
import br.unicesumar.escoladeti.entity.Endereco;
import br.unicesumar.escoladeti.entity.Pessoa;
import br.unicesumar.escoladeti.entity.PessoaFisica;
import br.unicesumar.escoladeti.entity.PessoaJuridica;
import br.unicesumar.escoladeti.service.PessoaService;
import br.unicesumar.escoladeti.view.PessoaFisicaJuridica;
import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public Pessoa atualizar(@Valid @RequestBody ComandoSalvarPessoa comando, @PathVariable("id") Long id) {
        return pessoaService.persistirPessoa(comando, id);
    }

    @RequestMapping(value = {"/{id}/{tipo}"}, method = RequestMethod.DELETE)
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

    @RequestMapping(value = {"/{pagina}"}, method = RequestMethod.GET)
    @ResponseBody
    public DataPage<PessoaFisicaJuridica> paginar(@PathVariable Integer pagina) {
        return pessoaService.paginarPessoaFisicaJuridica(pagina);
    }

    @RequestMapping(value = {"/buscarFisica/{pagina}"}, params = "busca", method = RequestMethod.GET)
    @ResponseBody
    public DataPage<PessoaFisica> buscarFisica(@PathVariable Integer pagina, @RequestParam String busca) {
        return pessoaService.buscarFisica(pagina, busca);
    }

    @RequestMapping(value = {"/buscarPessoa/{pagina}"}, params = "busca", method = RequestMethod.GET)
    @ResponseBody
    public DataPage<PessoaFisicaJuridica> buscarPessoa(@PathVariable Integer pagina, @RequestParam String busca) {
        return pessoaService.buscarPessoa(pagina, busca);
    }

    @RequestMapping(value = {"/paginarAluno/{pagina}"}, method = RequestMethod.GET)
    @ResponseBody
    public DataPage<PessoaFisica> paginarAluno(@PathVariable Integer pagina) {
        return pessoaService.paginarAluno(pagina);
    }

    @RequestMapping(value = {"/buscarAluno/{pagina}"}, params = "busca", method = RequestMethod.GET)
    @ResponseBody
    public DataPage<PessoaFisica> buscarAluno(@PathVariable Integer pagina, @RequestParam String busca) {
        return pessoaService.buscarAluno(pagina, busca);
    }

    @RequestMapping(value = {"/paginarJuridica/{pagina}"}, method = RequestMethod.GET)
    @ResponseBody
    public DataPage<PessoaJuridica> paginarJuridica(@PathVariable Integer pagina) {
        return pessoaService.paginarJuridica(pagina);
    }

    @RequestMapping(value = {"/buscarJuridica/{pagina}"}, params = "busca", method = RequestMethod.GET)
    @ResponseBody
    public DataPage<PessoaJuridica> buscarJuridica(@PathVariable Integer pagina, @RequestParam String busca) {
        return pessoaService.buscarJuridica(pagina, busca);
    }

    /**
     * @author Catabriga Metodos para retornar uma lista com todos alunos.
     * @return List de pessoas fisicas que são alunos
     */
    @RequestMapping(method = RequestMethod.GET, value = "/alunos")
    @ResponseBody
    public List<PessoaFisica> listarAlunos() {
        return pessoaService.listarAlunos();
    }

    /**
     * @author Catabriga Metodon para listar pessoas fisicas que não são alunos
     */
    @RequestMapping(method = RequestMethod.GET, value = "/fisicas")
    @ResponseBody
    public List<PessoaFisica> listarPessoasfisicas() {
        return pessoaService.listarPessoasFisicas();
    }

}
