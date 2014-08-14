package br.unicesumar.escoladeti.comando;

import br.unicesumar.escoladeti.entity.Telefone;
import br.unicesumar.escoladeti.enums.TipoTelefone;
import br.unicesumar.escoladeti.util.number.NumberUtils;
import br.unicesumar.escoladeti.util.string.StringUtils;
import org.parboiled.common.Preconditions;

public class ComandoSalvarTelefone {

    private String numero;

    private Integer ramal;

    private TipoTelefone tipo;

    private Integer ddd;

    public ComandoSalvarTelefone(TelefoneBuilder builder) {

    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Integer getRamal() {
        return ramal;
    }

    public void setRamal(Integer ramal) {
        this.ramal = ramal;
    }

    public TipoTelefone getTipo() {
        return tipo;
    }

    public void setTipo(TipoTelefone tipo) {
        this.tipo = tipo;
    }

    public Integer getDdd() {
        return ddd;
    }

    public void setDdd(Integer ddd) {
        this.ddd = ddd;
    }

    public static class TelefoneBuilder {

        private String numero;

        private Integer ramal;

        private TipoTelefone tipo;

        private Integer ddd;

        public TelefoneBuilder numero(String numero) {
            this.numero = numero;
            return this;
        }

        public TelefoneBuilder ramal(Integer ramal) {
            this.ramal = ramal;
            return this;
        }

        public TelefoneBuilder tipo(TipoTelefone tipo) {
            this.tipo = tipo;
            return this;
        }

        public TelefoneBuilder ddd(Integer ddd) {
            this.ddd = ddd;
            return this;
        }

        public Telefone build() {
            Preconditions.checkArgument(StringUtils.isNotEmpty(this.numero));
            Preconditions.checkNotNull(this.tipo);
            Preconditions.checkArgument(NumberUtils.isBiggerThanZero(this.ddd));

            Telefone telefone = new Telefone();

            telefone.setNumero(this.numero);
            telefone.setTipo(this.tipo);
            telefone.setRamal(this.ramal);
            telefone.setDdd(this.ddd);

            return telefone;
        }
    }
}
