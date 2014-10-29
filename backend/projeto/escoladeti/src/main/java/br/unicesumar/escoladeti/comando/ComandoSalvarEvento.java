package br.unicesumar.escoladeti.comando;

import br.unicesumar.escoladeti.entity.Participante;
import br.unicesumar.escoladeti.entity.Periodo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import java.util.Set;

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

    @Override
    public String toString() {
        return "ComandoSalvarEvento{" + "id=" + id + ", tipoEvento=" + tipoEvento + ", local=" + local + ", ministrante=" + ministrante + ", periodos=" + periodos + ", organizacao=" + organizacao + ", titulo=" + titulo + ", descricao=" + descricao + ", valor=" + valor + ", statusevento=" + statusevento + '}';
    }
    
}
