package br.unicesumar.escoladeti.comando;

import br.unicesumar.escoladeti.entity.Periodo;
import br.unicesumar.escoladeti.entity.Telefone;
import br.unicesumar.escoladeti.enums.TipoTelefone;
import br.unicesumar.escoladeti.util.number.NumberUtils;
import br.unicesumar.escoladeti.util.string.StringUtils;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;
import org.parboiled.common.Preconditions;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ComandoSalvarPeriodo {

    
    private Date data;
    @NotBlank(message = "Data inicial é obrigatória")
    private String inicio;
    @NotBlank(message = "Data final é obrigatória")
    private String fim;

    public ComandoSalvarPeriodo(PeriodoBuilder builder) {

    }

    public static PeriodoBuilder builder() {
        return new PeriodoBuilder();
    }

    public static class PeriodoBuilder {

        private Date data;
        private String inicio;
        private String fim;

        private Integer ddd;

        public PeriodoBuilder data(Date data) {
            this.data = data;
            return this;
        }

        public PeriodoBuilder inicio(String inicio) {
            this.inicio = inicio;
            return this;
        }
        
        public PeriodoBuilder fim(String fim) {
            this.fim = fim;
            return this;
        }


        public Periodo build() {
            Periodo periodo = new Periodo();

            periodo.setData(this.data);
            periodo.setInicio(this.inicio);
            periodo.setFim(this.fim);

            return periodo;
        }
    }
}
