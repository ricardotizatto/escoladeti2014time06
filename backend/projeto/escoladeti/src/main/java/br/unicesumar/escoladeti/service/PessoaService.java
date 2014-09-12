package br.unicesumar.escoladeti.service;

import br.unicesumar.escoladeti.comando.ComandoSalvarPessoa;
import br.unicesumar.escoladeti.controller.DataPage;
import static br.unicesumar.escoladeti.controller.DataPage.pageRequestForAsc;
import br.unicesumar.escoladeti.entity.Pessoa;
import br.unicesumar.escoladeti.entity.PessoaFisica;
import br.unicesumar.escoladeti.entity.PessoaJuridica;
import br.unicesumar.escoladeti.repository.PessoaFisicaJuridicaRepository;
import br.unicesumar.escoladeti.repository.PessoaFisicaRepository;
import br.unicesumar.escoladeti.repository.PessoaJuridicaRepository;
import br.unicesumar.escoladeti.view.PessoaFisicaJuridica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaJuridicaRepository pessoaJuridicaRepository;
    
    @Autowired
    private PessoaFisicaRepository pessoaFisicaRepository;
    
    @Autowired
    private PessoaFisicaJuridicaRepository pessoaFisicaJuridicaRepository;

    public DataPage<PessoaFisica> paginarFisica(Integer pagina) {
        return new DataPage<>(pessoaFisicaRepository.findAll(pageRequestForAsc(pagina, "nome")));
    }

    public DataPage<PessoaFisica> buscarFisica(Integer pagina, String busca) {
        return new DataPage<>(pessoaFisicaRepository.findByNomeContainingOrSobrenomeContainingOrCpfContainingOrderByNomeAsc(busca,busca,busca, pageRequestForAsc(pagina, "nome")));
    }

    public DataPage<PessoaFisica> paginarAluno(Integer pagina) {
        return new DataPage<>(pessoaFisicaRepository.findByAlunoTrue(pageRequestForAsc(pagina, "nome")));
    }

    public DataPage<PessoaFisica> buscarAluno(Integer pagina, String busca) {
        return new DataPage<>(pessoaFisicaRepository.findByNomeContainingAndAlunoTrueOrSobrenomeContainingAndAlunoTrueOrCpfContainingAndAlunoTrue(busca,busca,busca, pageRequestForAsc(pagina, "nome")));
    }

    public DataPage<PessoaJuridica> paginarJuridica(Integer pagina) {
        return new DataPage<>(pessoaJuridicaRepository.findAll(pageRequestForAsc(pagina, "nome")));
    }

    public DataPage<PessoaJuridica> buscarJuridica(Integer pagina, String busca) {
        return new DataPage<>(pessoaJuridicaRepository.findByNomeContainingOrCnpjContainingOrderByNomeAsc(busca, busca,pageRequestForAsc(pagina, "nome")));
    }

    public Pessoa buscar(Long id, String tipo){
        if (tipo.equals("J")) {
            return pessoaJuridicaRepository.findOne(id);
        } else if (tipo.equals("F")) {
            return pessoaFisicaRepository.findOne(id);
        }else{ 
            throw new RuntimeException("Tipo de pessoa inválido");
        }

    }

    public Pessoa persistirPessoa(ComandoSalvarPessoa comando, Long id){
        if (comando.getTipo().equals("F")) {
            if(id != null ||comando.getAluno() || pessoaFisicaRepository.findByCpf(comando.getCpf()) == null){
                PessoaFisica pessoaFisica = Pessoa.builder()
                        .telefones(comando.getTelefones())
                        .nome(comando.getNome())
                        .email(comando.getEmail())
                        .tipo(comando.getTipo())
                        .rg(comando.getRg())
                        .cpf(comando.getCpf())
                        .dataNascimento(comando.getDataNascimento())
                        .sobrenome(comando.getSobrenome())
                        .sexo(comando.getSexo())
                        .aluno(comando.getAluno())
                        .buildPessoaFisica();

                if (id != null) {
                    pessoaFisica.setId(id);
                }

                pessoaFisicaRepository.save(pessoaFisica);

                return pessoaFisica;
            }
            throw new RuntimeException("Já existe uma pessoa com o cpf "+ comando.getCpf() +" cadastrada no sistema");

        } else if (comando.getTipo().equals("J")) {
            if(id != null || pessoaJuridicaRepository.findByCnpj(comando.getCnpj()) == null ){
            PessoaJuridica pessoaJuridica = Pessoa.builder()
                    .telefones(comando.getTelefones())
                    .nome(comando.getNome())
                    .email(comando.getEmail())
                    .tipo(comando.getTipo())
                    .cnpj(comando.getCnpj())
                    .inscricaoEstadual(comando.getInscricaoEstadual())
                    .inscricaoMunicipal(comando.getInscricaoMunicipal())
                    .razaoSocial(comando.getRazaoSocial())
                    .dataCriacao(comando.getDataCriacao())
                    .buildPessoaJuridica();

            if (id != null) {
                pessoaJuridica.setId(id);
            }

            pessoaJuridicaRepository.save(pessoaJuridica);

            return pessoaJuridica;
            }
            throw new RuntimeException("Já existe uma pessoa com o cnpj"+ comando.getCnpj() +" cadastrada no sistema");
        }
        throw new RuntimeException("Tipo de pessoa inválido");
    }
    
    public void deletarPessoa(Long id, String tipo) {
        if (tipo.equals("J")) {
            pessoaJuridicaRepository.delete(id);
        } else if (tipo.equals("F")) {
            pessoaFisicaRepository.delete(id);
        }else{
            throw new RuntimeException("Tipo de pessoa inválido");
        }
    }


    public List<PessoaFisica> listarAlunos() {
        return pessoaFisicaRepository.findByAlunoTrue();
    }

    public List<PessoaFisica> listarPessoasFisicas() {
        return pessoaFisicaRepository.findByAlunoFalse();
    }

    public DataPage<PessoaFisicaJuridica> paginarPessoaFisicaJuridica(Integer pagina) {
        return new DataPage<>(pessoaFisicaJuridicaRepository.findAll(pageRequestForAsc(pagina, "nome")));
    }
    public DataPage<PessoaFisicaJuridica> buscarPessoa(Integer pagina, String busca) {
        return new DataPage<>(pessoaFisicaJuridicaRepository.findByNomeContainingOrCpfCnpjContainingOrderByNomeAsc(busca,busca, pageRequestForAsc(pagina, "nome")));
    }
}
