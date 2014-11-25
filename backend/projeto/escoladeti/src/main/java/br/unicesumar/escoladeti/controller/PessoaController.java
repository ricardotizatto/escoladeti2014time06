package br.unicesumar.escoladeti.controller;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.unicesumar.escoladeti.comando.ComandoSalvarPessoa;
import br.unicesumar.escoladeti.entity.Pessoa;
import br.unicesumar.escoladeti.entity.PessoaFisica;
import br.unicesumar.escoladeti.entity.PessoaJuridica;
import br.unicesumar.escoladeti.service.PessoaService;
import br.unicesumar.escoladeti.view.PessoaFisicaJuridica;
import br.unicesumar.escoladeti.view.ViewPessoaAssociado;

@Controller
@RequestMapping("/rest/pessoas")
public class PessoaController implements Serializable {

  private static final long serialVersionUID = 1L;

  @Autowired
  private PessoaService pessoaService;

  @RequestMapping(method = RequestMethod.POST)
  @ResponseBody
  public Pessoa salvar(@Valid @RequestBody ComandoSalvarPessoa comando) {
    //throw new RuntimeException("Aqui : " + pessoaCaracteristica.getCaracteristicas().size());
    return pessoaService.persistirPessoa(comando, null);
  }

  @RequestMapping(value = {"/{id}"}, method = RequestMethod.PUT)
  @ResponseBody
  public Pessoa atualizar(@Valid @RequestBody ComandoSalvarPessoa comando,
          @PathVariable("id") Long id) {
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
  public DataPage<PessoaFisica> buscarFisica(@PathVariable Integer pagina,
          @RequestParam String busca) {
    return pessoaService.buscarFisica(pagina, busca);
  }

  @RequestMapping(value = {"/buscarPessoa/{pagina}"}, params = "busca", method = RequestMethod.GET)
  @ResponseBody
  public DataPage<PessoaFisicaJuridica> buscarPessoa(
          @PathVariable Integer pagina, @RequestParam String busca) {
    return pessoaService.buscarPessoa(pagina, busca);
  }

  @RequestMapping(value = {"/paginarJuridica/{pagina}"}, method = RequestMethod.GET)
  @ResponseBody
  public DataPage<PessoaJuridica> paginarJuridica(@PathVariable Integer pagina) {
    return pessoaService.paginarJuridica(pagina);
  }

  @RequestMapping(value = {"/buscarJuridica/{pagina}"}, params = "busca", method = RequestMethod.GET)
  @ResponseBody
  public DataPage<PessoaJuridica> buscarJuridica(
          @PathVariable Integer pagina, @RequestParam String busca) {
    return pessoaService.buscarJuridica(pagina, busca);
  }

  /**
   * @author Lorhan // metodo para listar todas pessoas alunos ou não
   */
  @RequestMapping(method = RequestMethod.GET, value = "/todasPessoas")
  @ResponseBody
  public List<PessoaFisicaJuridica> listarTodasPessoas() {
    return pessoaService.listarTodasPessoas();
  }
  
  @RequestMapping(method = RequestMethod.GET, value = "/todosAssociados")
  @ResponseBody
  public List<ViewPessoaAssociado> listarTodosAssociados(){
	  return this.pessoaService.listaTodosAssociados();
  }
  
  @RequestMapping(method = RequestMethod.GET, value = "/listarTodasAsEscolas")
  @ResponseBody
  public List<Map<String, Object>> listarTodasAsEscolas(){
	  return this.pessoaService.listarTodasAsEscolas();
  }


    @RequestMapping(method = RequestMethod.GET, value = "/todasPessoasfisicas")
    @ResponseBody
    public List<PessoaFisica> listarTodasPessoasFisicas() {
        return pessoaService.listarTodasPessoasFisicas();
    }

  @RequestMapping(method = RequestMethod.GET, value = "/listarTodas/{pagina}")
  @ResponseBody
  public DataPage<PessoaFisicaJuridica> listarTodos(@PathVariable Integer pagina) {
    return pessoaService.listarTodos(pagina);
  }

}
