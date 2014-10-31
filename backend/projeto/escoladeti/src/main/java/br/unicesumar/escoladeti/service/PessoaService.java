package br.unicesumar.escoladeti.service;

import static br.unicesumar.escoladeti.controller.DataPage.pageRequestForAsc;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.unicesumar.escoladeti.comando.ComandoSalvarPessoa;
import br.unicesumar.escoladeti.controller.DataPage;
import br.unicesumar.escoladeti.entity.Caracteristica;
import br.unicesumar.escoladeti.entity.Pessoa;
import br.unicesumar.escoladeti.entity.PessoaCaracteristica;
import br.unicesumar.escoladeti.entity.PessoaFisica;
import br.unicesumar.escoladeti.entity.PessoaJuridica;
import br.unicesumar.escoladeti.entity.VigenciaAssociado;
import br.unicesumar.escoladeti.repository.CaracteristicaRepository;
import br.unicesumar.escoladeti.repository.PessoaFisicaJuridicaRepository;
import br.unicesumar.escoladeti.repository.PessoaFisicaRepository;
import br.unicesumar.escoladeti.repository.PessoaJuridicaRepository;
import br.unicesumar.escoladeti.view.PessoaFisicaJuridica;

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
		return new DataPage<>(pessoaFisicaRepository.findAll(pageRequestForAsc(
				pagina, "nome")));
	}

	public DataPage<PessoaFisica> buscarFisica(Integer pagina, String busca) {
		return new DataPage<>(
				pessoaFisicaRepository
						.findByNomeContainingOrSobrenomeContainingOrCpfContainingOrderByNomeAsc(
								busca, busca, busca,
								pageRequestForAsc(pagina, "nome")));
	}

	public DataPage<PessoaJuridica> paginarJuridica(Integer pagina) {
		return new DataPage<>(
				pessoaJuridicaRepository.findAll(pageRequestForAsc(pagina,
						"nome")));
	}

	public DataPage<PessoaJuridica> buscarJuridica(Integer pagina, String busca) {
		return new DataPage<>(
				pessoaJuridicaRepository
						.findByNomeContainingOrCnpjContainingOrderByNomeAsc(
								busca, busca, pageRequestForAsc(pagina, "nome")));
	}

	public Pessoa buscar(Long id, String tipo) {
		if (tipo.equals("J")) {
			return pessoaJuridicaRepository.findOne(id);
		} else if (tipo.equals("F")) {
			return pessoaFisicaRepository.findOne(id);
		} else {
			throw new RuntimeException("Tipo de pessoa inválido");
		}

	}

	@Transactional
	public Pessoa persistirPessoa(ComandoSalvarPessoa comando, Long id) {

		if (comando.getTipo().equals("F")) {

			if (comando.getCpf() != null && !comando.getCpf().isEmpty()) {
				PessoaFisica pf = pessoaFisicaRepository.findByCpf(comando
						.getCpf());
				cpfExiste(pf, id);
			}
			PessoaFisica pessoaFisica = buildPessoaFisica(comando);

			if (id != null) {
				pessoaFisica.setId(id);
			}
			List<Long> ids = comando.getCaracteristicas();
			List<PessoaCaracteristica> pcs = new ArrayList<PessoaCaracteristica>();

			for (int i = 0; i < ids.size(); i++) {
				PessoaCaracteristica pc = new PessoaCaracteristica();
				pc.setPessoa(pessoaFisica);
				Caracteristica c = this.caracteristicaRepository.findOne(ids
						.get(i));
				pc.setCaracteristica(c);
				pc.setPessoa(pessoaFisica);

				if (comando.getVigenciaAssociado() != null && ids.get(i) == 2) {
					VigenciaAssociado va = new VigenciaAssociado();
					va.setVigencia(comando.getVigenciaAssociado());

					Date dt = new Date();

					if (dt.after(va.getVigencia()))
						throw new RuntimeException(
								"Vigência não pode ser menor que hoje!");

					va.setPessoaCaracteristica(pc);
					pc.setVigenciaAssociado(va);
				}

				pcs.add(pc);
			}

			pessoaFisica.setPessoaCaracteristica(pcs);
			pessoaFisicaRepository.save(pessoaFisica);

			return pessoaFisica;

		} else if (comando.getTipo().equals("J")) {
			PessoaJuridica pj = pessoaJuridicaRepository.findByCnpj(comando
					.getCnpj());
			if (pj != null) {
				if (pj.getCnpj().equals(comando.getCnpj())
						&& !Objects.equals(pj.getId(), id)) {
					throw new RuntimeException("CNPJ já cadastrado.");
				}
			}
			if (id != null
					|| pessoaJuridicaRepository.findByCnpj(comando.getCnpj()) == null) {
				PessoaJuridica pessoaJuridica = Pessoa.builder()
						.telefones(comando.getTelefones())
						.enderecos(comando.getEnderecos())
						.nome(comando.getNome()).email(comando.getEmail())
						.tipo(comando.getTipo()).cnpj(comando.getCnpj())
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
			throw new RuntimeException("Já existe uma pessoa com o cnpj"
					+ comando.getCnpj() + " cadastrada no sistema");
		}
		throw new RuntimeException("Tipo de pessoa inválido");
	}

	private PessoaFisica buildPessoaFisica(ComandoSalvarPessoa comando) {
		return Pessoa.builder().telefones(comando.getTelefones())
				.enderecos(comando.getEnderecos()).nome(comando.getNome())
				.email(comando.getEmail()).tipo(comando.getTipo())
				.rg(comando.getRg()).cpf(comando.getCpf())
				.dataNascimento(comando.getDataNascimento())
				.sobrenome(comando.getSobrenome()).sexo(comando.getSexo())
				.buildPessoaFisica();
	}

	private void cpfExiste(PessoaFisica pf, Long id) {
		if (pf != null && id != null) {
			if (this.pessoaFisicaRepository.findByCpf(pf.getCpf()) != null
					&& !pf.getCpf().isEmpty() && !pf.getId().equals(id))
				throw new RuntimeException("CPF já cadastrado.");
		}

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

	public List<PessoaFisicaJuridica> listarTodasPessoas() {
		return this.pessoaFisicaJuridicaRepository.findAll();
	}

	public DataPage<PessoaFisicaJuridica> paginarPessoaFisicaJuridica(
			Integer pagina) {
		return new DataPage<>(
				pessoaFisicaJuridicaRepository.findAll(pageRequestForAsc(
						pagina, "nome")));
	}

	public DataPage<PessoaFisicaJuridica> buscarPessoa(Integer pagina,
			String busca) {
		return new DataPage<>(
				pessoaFisicaJuridicaRepository
						.findByNomeContainingOrCpfCnpjContainingOrderByNomeAsc(
								busca, busca, pageRequestForAsc(pagina, "nome")));
	}

	public DataPage<PessoaFisicaJuridica> listarTodos(Integer pagina) {
		return new DataPage<>(this.pessoaFisicaJuridicaRepository.findAll(pageRequestForAsc(pagina, "nome")));
	}

    public List<PessoaFisica> lsitarPessoasFisicas() {
        return pessoaFisicaRepository.findAll();
    }
}
