package br.unicesumar.escoladeti.controller;

import br.unicesumar.escoladeti.service.RelatorioEstoqueProdutoService;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/relatorio/estoque")
public class RelatorioEstoqueProdutoController implements Serializable {

    @Autowired
    private RelatorioEstoqueProdutoService relatorioEstoqueProduto;

    @RequestMapping(method = RequestMethod.GET)
    public void imprimirRelatorio( HttpServletResponse response) throws IOException, JRException, SQLException {
        relatorioEstoqueProduto.imprimir(response);

    }
}
