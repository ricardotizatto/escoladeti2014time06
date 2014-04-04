package enderecamento;

import java.util.Date;

class UsuarioPerfilAcesso {

    private Date inicioVigencia;
    private Date fimVigencia;
    private Usuario usuario;
    private PerfilDeAcesso perfilAcesso;

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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public PerfilDeAcesso getPerfilAcesso() {
        return perfilAcesso;
    }

    public void setPerfilAcesso(PerfilDeAcesso perfilAcesso) {
        this.perfilAcesso = perfilAcesso;
    }
}
