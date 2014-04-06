package enderecamento;

import java.util.Date;

class Distrito {
    private Date inicioVigencia;
    private Date fimVigencia;
    private Cidade municipio;
    private Cidade distrito;

    public Date getInicioVigencia() {
        return inicioVigencia;
    }

    public void setInicioVigencia(Date inicioVigencia) {
        this.inicioVigencia = inicioVigencia;
    }

    public Date getFimVigencia() {
        return fimVigencia;
    }

    public void setFimVigencia(Date fimVigencia) {
        this.fimVigencia = fimVigencia;
    }

    public Cidade getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Cidade municipio) {
        this.municipio = municipio;
    }

    public Cidade getDistrito() {
        return distrito;
    }

    public void setDistrito(Cidade distrito) {
        this.distrito = distrito;
    }
}
