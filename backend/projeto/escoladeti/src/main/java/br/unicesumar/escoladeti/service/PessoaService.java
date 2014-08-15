package br.unicesumar.escoladeti.service;

import br.unicesumar.escoladeti.comando.ComandoSalvarPessoa;
import br.unicesumar.escoladeti.controller.DataPage;
import br.unicesumar.escoladeti.entity.Pessoa;
import br.unicesumar.escoladeti.entity.PessoaFisica;
import br.unicesumar.escoladeti.entity.PessoaJuridica;
import br.unicesumar.escoladeti.repository.PessoaFisicaRepository;
import br.unicesumar.escoladeti.repository.PessoaJuridicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    private PessoaJuridicaRepository pessoaJuridicaRepository;
    @Autowired
    private PessoaFisicaRepository pessoaFisicaRepository;

    public void deletar(Long id) {
//        pessoaRepository.delete(id);
    }

    public DataPage<Pessoa> paginar(Integer pagina, String tipo) {
        
//        return new DataPage<>(pessoaRepository.findAll(pageRequestForAsc(pagina, "id")));
        return null;
    }

    public Pessoa buscar(Long id) {
//        return pessoaRepository.findOne(id);
        return null;
    }

    public Pessoa salvar(ComandoSalvarPessoa comando) {
        if (comando.getTipo().equals("F")) {
            PessoaFisica pessoaFisica = Pessoa.builder()
                    .nome(comando.getNome())
                    .email(comando.getEmail())
                    .tipo(comando.getTipo())
                    .rg(comando.getRg())
                    .cpf(comando.getCpf())
                    .dataNascimento(comando.getDataNascimento())
                    .sobrenome(comando.getSobrenome())
                    .sexo(comando.getSexo())
                    .papel(comando.getPapel())
                    .buildPessoaFisica();
            
            pessoaFisicaRepository.save(pessoaFisica);
            
            return pessoaFisica;

        } else if (comando.getTipo().equals("J")) {
            PessoaJuridica pessoaJuridica = Pessoa.builder()
                    .nome(comando.getNome())
                    .email(comando.getEmail())
                    .cnpj(comando.getCnpj())
                    .inscricaoEstadual(comando.getInscricaoEstadual())
                    .inscricaoMunicipal(comando.getInscricaoMunicipal())
                    .razaoSocial(comando.getRazaoSocial())
                    .dataCriacao(comando.getDataCriacao())
                    .buildPessoaJuridica();
            
            pessoaJuridicaRepository.save(pessoaJuridica);
            
            return pessoaJuridica;
        }
        throw new RuntimeException("Tipo de pessoa inválido");
    }

}
