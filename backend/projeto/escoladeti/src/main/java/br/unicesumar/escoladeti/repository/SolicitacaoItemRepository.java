package br.unicesumar.escoladeti.repository;

import br.unicesumar.escoladeti.dto.AcompanhamentoDTO;
import br.unicesumar.escoladeti.entity.Solicitacao;
import br.unicesumar.escoladeti.entity.SolicitacaoItem;
import br.unicesumar.escoladeti.pesquisa.PesquisaSolicitacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitacaoItemRepository extends JpaRepository<SolicitacaoItem, Long>{
    
    /*
    @Autowired
    private DataSource dataSource;
    public List<AcompanhamentoDTO>listarItens(PesquisaSolicitacao pesquisa) {
        List<AcompanhamentoDTO>itens = new ArrayList<>();
        String consultaBase = "select  si.status, so.id codigoSolicitacao, pe.nome   from solicitacaoitem  si "
                + " join solicitacao so on(si.id_solicitacao = so.id) "
                + " join pessoafisica pf on(pf.id = so.id_responsavel)  "
                + " join pessoa pe on (pf.id = pe.id) "
                + " where 1=1 ";
        if (pesquisa.getStatus() != null) {
            consultaBase += " and si.status =" + pesquisa.getStatus();
        }
        try {
            Connection conexao = dataSource.getConnection();
            PreparedStatement preparedStatement = conexao.prepareStatement(consultaBase);
            ResultSet resultado = preparedStatement.executeQuery();
//Enquanto possuis um próximo registro
            while (resultado.next()) {
                //Montaor dto
                AcompanhamentoDTO acompanhamentoDTO = new AcompanhamentoDTO();
                acompanhamentoDTO.setStatus(resultado.getString("status"));
               
                acompanhamentoDTO.nome(resultado.getString("nome"));
                acompanhamentoDTO.s setSolicitacaoID(resultado.getLong("codigoSolicitacao"));
                
                itens.add(acompanhamentoDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("erro ao realizar pesquisa");
        }
        return itens;
    }*/
}
