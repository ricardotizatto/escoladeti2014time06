package br.unicesumar.escoladeti.comando;

import br.unicesumar.escoladeti.entity.Participante;
import br.unicesumar.escoladeti.entity.Periodo;
import br.unicesumar.escoladeti.entity.Pessoa;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.BASE64Decoder;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ComandoSalvarEvento {
    
    private Long id;
    private String tipoEvento;
    private String local;
    private String ministrante;
    private List<Participante> participante;
    private Set<Periodo> periodos;
    private String organizacao;
    private String titulo;
    private String descricao;
    private double valor;
    private boolean statusevento;
    private Integer limite;
    private Integer disponivel;
    private byte[] foto;
    
    public Integer getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Integer disponivel) {
        this.disponivel = disponivel;
    }

    public ComandoSalvarEvento() {
    }
 
    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getMinistrante() {
        return ministrante;
    }

    public void setMinistrante(String ministrante) {
        this.ministrante = ministrante;
    }

    public Set<Periodo> getPeriodos() {
        System.out.println("get total no comando salvar= "+ periodos.size());
        return periodos;
    }

    public void setPeriodos(Set<Periodo> periodos) {
        System.out.println("set total no comando salvar= "+ periodos.size());
        this.periodos = periodos;
    }

    public String getOrganizacao() {
        return organizacao;
    }

    public void setOrganizacao(String organizacao) {
        this.organizacao = organizacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean isStatusevento() {
        return statusevento;
    }

    public void setStatusevento(boolean statusevento) {
        this.statusevento = statusevento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Integer getLimite() {
        return limite;
    }

    public void setLimite(Integer limite) {
        this.limite = limite;
    }
    
    public byte[] getFoto() {
        return this.foto;
    }

    public void setFoto(String foto) {
        String imagem = foto.replaceAll("data:image/png;base64,", "");
        imagem = imagem.replaceAll("data:image/jpeg;base64,", "");
        byte[] imageByte = null;

        try {
                BASE64Decoder decoder;
                decoder = new BASE64Decoder();
                imageByte = decoder.decodeBuffer(imagem);
        } catch (IOException ex) {
                Logger.getLogger(Pessoa.class.getName())
                                .log(Level.SEVERE, null, ex);
        }
        this.foto = imageByte;
    }

    @Override
    public String toString() {
        return "ComandoSalvarEvento{" + "id=" + id + ", tipoEvento=" + tipoEvento + ", local=" + local + ", ministrante=" + ministrante + ", periodos=" + periodos + ", organizacao=" + organizacao + ", titulo=" + titulo + ", descricao=" + descricao + ", valor=" + valor + ", statusevento=" + statusevento + '}';
    }
    
}
