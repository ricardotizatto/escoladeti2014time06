package br.unicesumar.escoladeti.repository;

import br.unicesumar.escoladeti.dto.AcompanhamentoDTO;
import br.unicesumar.escoladeti.pesquisa.PesquisaSolicitacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;

public class SolicitacaoItemRepository{
    
    @Autowired
    private DataSource dataSource;
    public List<AcompanhamentoDTO>listarItens(PesquisaSolicitacao pesquisa) {
        List<AcompanhamentoDTO>itens = new ArrayList<>();
        String consultaBase = "select  so.datachegada dataChegada, so.id id_solicitacao, pe.nome responsavel, si.traducaomaterial traducao, op.id ordemId,si.status, li.nome nomeMaterial from solicitacaoitem  si "
                + " join solicitacao so on(so.id = si.id_solicitacao) "
                + " join pessoafisica pf on(pf.id = so.id_responsavel) " 
                + " join pessoa pe on(pf.id = pe.id) "
                + " left join ordemproducao op on(op.solicitacaoitem_id = si.id) "
                + " left join material ma on(ma.id = si.id_material) "
                + " left join livro li on(li.id = si.id_material) "
                + " where 1=1 ";
        
        //fazer as outras clausulas 
        if (pesquisa.getStatus() != null) {
            consultaBase += " and si.status =" + pesquisa.getStatus();
        }
        if(pesquisa.getDataInicio() != null && pesquisa.getDataFim() != null){
            consultaBase += " and so.datachegada between =" + pesquisa.getDataInicio() + " and " + pesquisa.getDataFim();
        }
        if(pesquisa.getSolicitacaoId() != null){
            consultaBase += " and id_solicitacao =" +pesquisa.getSolicitacaoId();
        }
        if(pesquisa.getOrdemId() != null){
            consultaBase += " and op.id =" + pesquisa.getOrdemId();
        }
        if(pesquisa.getMaterial() != null){
            consultaBase += " and li.nome =" +pesquisa.getMaterial();
        }
        if(pesquisa.getResponsavel() != null){
            consultaBase += " and pe.nome =" +pesquisa.getResponsavel();
        }
//        verificar de onde busca o revisor
//        if(pesquisa.getRevisor()!= null){
//            consultaBase += " and pe.nome =" +pesquisa.getRevisor();
//        }
        try {
            Connection conexao = dataSource.getConnection();
            PreparedStatement preparedStatement = conexao.prepareStatement(consultaBase);
            ResultSet resultado = preparedStatement.executeQuery();
            //Enquanto possuis um próximo registro
            while (resultado.next()) {
                //Montaor dto
                AcompanhamentoDTO acompanhamentoDTO = new AcompanhamentoDTO();
                acompanhamentoDTO.setStatus(resultado.getString("status"));
                acompanhamentoDTO.setDataChegada(resultado.getDate("dataChegada"));
                acompanhamentoDTO.setTraducao(resultado.getString("traducao"));
                acompanhamentoDTO.setResponsavel(resultado.getString("responsavel"));
                acompanhamentoDTO.setOrdemId(resultado.getLong("ordemId"));
                acompanhamentoDTO.setMaterial(resultado.getString("nomeMaterial"));
//                acompanhamentoDTO.setDataEnvio(resultado.getDate("dataEnvio")); NAO EXISTE AINDA
                
                itens.add(acompanhamentoDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("erro ao realizar pesquisa");
        }
        return itens;
    }
}
