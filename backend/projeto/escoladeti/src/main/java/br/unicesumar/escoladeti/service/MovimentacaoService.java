package br.unicesumar.escoladeti.service;

import br.unicesumar.escoladeti.comando.ComandoSalvarMovimentacao;
import br.unicesumar.escoladeti.controller.DataPage;
import static br.unicesumar.escoladeti.controller.DataPage.pageRequestForAsc;
import br.unicesumar.escoladeti.entity.Movimentacao;
import br.unicesumar.escoladeti.entity.Movimentacao.MovimentacaoBuilder;
import br.unicesumar.escoladeti.entity.Pessoa;
import br.unicesumar.escoladeti.entity.Produto;
import br.unicesumar.escoladeti.repository.MovimentacaoRepository;
import br.unicesumar.escoladeti.repository.PessoaFisicaRepository;
import br.unicesumar.escoladeti.repository.PessoaJuridicaRepository;
import br.unicesumar.escoladeti.repository.ProdutoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovimentacaoService {

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    @Autowired
    private PessoaFisicaRepository pessoaFisicaRepository;

    @Autowired
    private PessoaJuridicaRepository pessoaJuridicaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public Movimentacao salvar(ComandoSalvarMovimentacao comando) throws Exception {
        Pessoa pessoaOrigem = this.pessoaFisicaRepository.findById(comando.getPessoaOrigem());
        Pessoa pessoaDestino = this.pessoaFisicaRepository.findById(comando.getPessoaDestino());
        Produto produto = this.produtoRepository.findById(comando.getProduto());
        
        MovimentacaoBuilder movimentacaoBuilder = Movimentacao
                .builder()
                .Tipo(comando.getTipo())
                .Quantidade(comando.getQuantidade())
                .DataMovimentacao(comando.getDataMovimentacao())
                .PessoaOrigem(pessoaOrigem)
                .PessoaDestino(pessoaDestino)
                .Produto(produto);
        
        Movimentacao movimentacao = movimentacaoBuilder.build();
        this.alteraQuantidadeProduto(movimentacao);
        return this.movimentacaoRepository.save(movimentacao);
    }

    public List<Movimentacao> listaTodos() {
        return this.movimentacaoRepository.findAll();
    }

    public DataPage<Movimentacao> getTodos(Integer pagina) {
        return new DataPage<>(movimentacaoRepository.findAll(pageRequestForAsc(pagina, "id")));
    }

    public Movimentacao getById(Long id) {
        return this.movimentacaoRepository.findById(id);
    }

    public DataPage<Movimentacao> getPorNome(String q) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Produto alteraQuantidadeProduto(Movimentacao movimentacao) throws Exception {
        Produto produto = this.produtoRepository.findById(movimentacao.getProduto().getId());

        Long novaQuantidade = produto.getQuantidade() + (movimentacao.getQuantidade() * movimentacao.getTipo());
        if (novaQuantidade < 0) {
            throw new Exception("Não possui estoque suficiente");
        }

        produto.setQuantidade(novaQuantidade);
        return this.produtoRepository.save(produto);
    }
    
    public Movimentacao extornar(Long id) throws Exception {
        Movimentacao movimentacao = this.movimentacaoRepository.findById(id);
        movimentacao.setTipo(movimentacao.getTipo() * -1);
        this.alteraQuantidadeProduto(movimentacao);
        
        movimentacao.setId(null);
        this.movimentacaoRepository.save(movimentacao);
        
        movimentacao.setExtornado(true);
        return this.movimentacaoRepository.save(movimentacao);
    }

}
