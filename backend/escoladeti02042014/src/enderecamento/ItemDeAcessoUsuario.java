package enderecamento;

import java.util.Date;

class ItemDeAcessoUsuario {
    private Date inicioVigencia;
    private Date fimVigencia;
    private ItemDeAcesso item;
    private Usuario usuario;

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

    public ItemDeAcesso getItem() {
        return item;
    }

    public void setItem(ItemDeAcesso item) {
        this.item = item;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
