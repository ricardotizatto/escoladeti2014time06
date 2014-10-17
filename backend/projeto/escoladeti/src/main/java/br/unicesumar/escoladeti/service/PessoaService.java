package br.unicesumar.escoladeti.service;

import br.unicesumar.escoladeti.comando.ComandoSalvarPessoa;
import br.unicesumar.escoladeti.controller.DataPage;
import static br.unicesumar.escoladeti.controller.DataPage.pageRequestForAsc;
import br.unicesumar.escoladeti.entity.Caracteristica;
import br.unicesumar.escoladeti.entity.Endereco;
import br.unicesumar.escoladeti.entity.Pessoa;
import br.unicesumar.escoladeti.entity.PessoaFisica;
import br.unicesumar.escoladeti.entity.PessoaJuridica;
import br.unicesumar.escoladeti.repository.CaracteristicaRepository;
import br.unicesumar.escoladeti.repository.PessoaFisicaJuridicaRepository;
import br.unicesumar.escoladeti.repository.PessoaFisicaRepository;
import br.unicesumar.escoladeti.repository.PessoaJuridicaRepository;
import br.unicesumar.escoladeti.view.PessoaFisicaJuridica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
public class PessoaService {

    @Autowired
    private PessoaJuridicaRepository pessoaJuridicaRepository;

    @Autowired
    private PessoaFisicaRepository pessoaFisicaRepository;

    @Autowired
    private PessoaFisicaJuridicaRepository pessoaFisicaJuridicaRepository;
    
    @Autowired
    private CaracteristicaRepository caracteristicaRepository;

    public DataPage<PessoaFisica> paginarFisica(Integer pagina) {
        return new DataPage<>(pessoaFisicaRepository.findAll(pageRequestForAsc(pagina, "nome")));
    }

    public DataPage<PessoaFisica> buscarFisica(Integer pagina, String busca) {
        return new DataPage<>(pessoaFisicaRepository.findByNomeContainingOrSobrenomeContainingOrCpfContainingOrderByNomeAsc(busca, busca, busca, pageRequestForAsc(pagina, "nome")));
    }

    public DataPage<PessoaJuridica> paginarJuridica(Integer pagina) {
        return new DataPage<>(pessoaJuridicaRepository.findAll(pageRequestForAsc(pagina, "nome")));
    }

    public DataPage<PessoaJuridica> buscarJuridica(Integer pagina, String busca) {
        return new DataPage<>(pessoaJuridicaRepository.findByNomeContainingOrCnpjContainingOrderByNomeAsc(busca, busca, pageRequestForAsc(pagina, "nome")));
    }

    public Pessoa buscar(Long id, String tipo) {
        if (tipo.equals("J")) {
            return pessoaJuridicaRepository.findOne(id);
        } else if (tipo.equals("F")) {
            return pessoaFisicaRepository.findOne(id);
        } else {
            throw new RuntimeException("Tipo de pessoa invÃ¡lido");
        }

    }

    public Pessoa persistirPessoa(ComandoSalvarPessoa comando, Long id) {

        if (comando.getTipo().equals("F")) {
            PessoaFisica pf = pessoaFisicaRepository.findByCpf(comando.getCpf());
            
            if (pf != null) {
                if (id == null || !Objects.equals(pf.getId(), id)) {
                    throw new RuntimeException("CPF já cadastrado.");
                }
            }

            if (id != null || comando.getCaracteristicas().contains(1) || pessoaFisicaRepository.findByCpf(comando.getCpf()) == null) {
            	Set<Caracteristica> caracteristicas = new HashSet<Caracteristica>();
            	
            	for (Long idCaracteristica : comando.getCaracteristicas()) {
            		Caracteristica c = this.caracteristicaRepository.findOne(idCaracteristica);
            		caracteristicas.add(c);
            		System.out.println(c.getDescricao());
				} 
            	
                PessoaFisica pessoaFisica = Pessoa.builder()
                        .telefones(comando.getTelefones())
                        .enderecos(comando.getEnderecos())
                        .nome(comando.getNome())
                        .email(comando.getEmail())
                        .tipo(comando.getTipo())
                        .rg(comando.getRg())
                        .cpf(comando.getCpf())
                        .dataNascimento(comando.getDataNascimento())
                        .sobrenome(comando.getSobrenome())
                        .sexo(comando.getSexo())
                        .caracteristicas(caracteristicas)
                        .buildPessoaFisica();

                if (id != null) {
                    pessoaFisica.setId(id);
                }

                pessoaFisicaRepository.save(pessoaFisica);

                return pessoaFisica;
            }
            throw new RuntimeException("Já existe uma pessoa com o cpf " + comando.getCpf() + " cadastrada no sistema");

        } else if (comando.getTipo().equals("J")) {
            PessoaJuridica pj = pessoaJuridicaRepository.findByCnpj(comando.getCnpj());
            if (pj != null) {
                if (pj.getCnpj().equals(comando.getCnpj()) && !Objects.equals(pj.getId(), id)) {
                    throw new RuntimeException("CNPJ já cadastrado.");
                }
            }
            if (id != null || pessoaJuridicaRepository.findByCnpj(comando.getCnpj()) == null) {
                PessoaJuridica pessoaJuridica = Pessoa.builder()
                        .telefones(comando.getTelefones())
                        .enderecos(comando.getEnderecos())
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
            throw new RuntimeException("JÃ¡ existe uma pessoa com o cnpj" + comando.getCnpj() + " cadastrada no sistema");
        }
        throw new RuntimeException("Tipo de pessoa invÃ¡lido");
    }

    public void deletarPessoa(Long id, String tipo) {
        if (tipo.equals("J")) {
            pessoaJuridicaRepository.delete(id);
        } else if (tipo.equals("F")) {
            pessoaFisicaRepository.delete(id);
        } else {
            throw new RuntimeException("Tipo de pessoa invÃ¡lido");
        }
    }
    
    public List<PessoaFisica> listarTodasPessoas(){
        return pessoaFisicaRepository.findAll();
    }

    public DataPage<PessoaFisicaJuridica> paginarPessoaFisicaJuridica(Integer pagina) {
        return new DataPage<>(pessoaFisicaJuridicaRepository.findAll(pageRequestForAsc(pagina, "nome")));
    }

    public DataPage<PessoaFisicaJuridica> buscarPessoa(Integer pagina, String busca) {
        return new DataPage<>(pessoaFisicaJuridicaRepository.findByNomeContainingOrCpfCnpjContainingOrderByNomeAsc(busca, busca, pageRequestForAsc(pagina, "nome")));
    }
}
