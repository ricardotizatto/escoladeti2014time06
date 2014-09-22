package br.unicesumar.escoladeti.controller;

import br.unicesumar.escoladeti.service.RelatorioParticipanteService;
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
@RequestMapping("/relatorio/participantes")
public class RelatorioParticipanteEventoController implements Serializable {

    @Autowired
    private RelatorioParticipanteService relatorioParticipanteService;
    
    @RequestMapping(value="/{idevento}", method = RequestMethod.GET)
    public void imprimirRelatorio(@PathVariable Long idevento, HttpServletResponse response) throws IOException, JRException, SQLException {
        relatorioParticipanteService.imprimir(idevento, response);
    }
}
