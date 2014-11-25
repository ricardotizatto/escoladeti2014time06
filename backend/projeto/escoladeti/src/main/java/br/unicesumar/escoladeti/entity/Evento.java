package br.unicesumar.escoladeti.entity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Evento extends Entidade {

    private static final long serialVersionUID = 1L;
    
    private String tipoEvento;
    private String local;
    private String ministrante;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idevento", referencedColumnName = "id", updatable = false)
    private List<Participante> participante;
    
    @NotEmpty(message = "Deve ser cadastrado ao menos um Endereço!")
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "evento", cascade = CascadeType.ALL, orphanRemoval = true)    
    private Set<Periodo> periodos;    
    
    private String organizacao;
    private String titulo;
    private String descricao;
    private double valor;
    private boolean statusevento;
    private Integer limite;
    private Integer disponivel;

    public Integer getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Integer disponivel) {
        this.disponivel = disponivel;
    }

    public Evento() {
        this.periodos = new HashSet<Periodo>();
    }

    public Set<Periodo> getPeriodos() {
        return periodos;
    }

    public void setPeriodos(Set<Periodo> periodos) {
        this.periodos = periodos;
    }

    public String getOrganizacao() {
        return organizacao;
    }

    public void setOrganizacao(String organizacao) {
        this.organizacao = organizacao.toUpperCase();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo.toUpperCase();
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao.toUpperCase();
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento.toUpperCase();
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local.toUpperCase();
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getMinistrante() {
        return ministrante;
    }

    public void setMinistrante(String ministrante) {
        this.ministrante = ministrante.toUpperCase();
    }

    public boolean getStatusevento() {
        return statusevento;
    }

    public void setStatusevento(boolean statusevento) {
        this.statusevento = statusevento;
    }
    
    public Integer getLimite() {
        return limite;
    }

    public void setLimite(Integer limite) {
        this.limite = limite;
    }
    
    public static EventoBuilder builder(){
        return new EventoBuilder();
    }
    
    public static class EventoBuilder{
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
        
        public EventoBuilder tipoEvento(String tipoEvento){
            this.tipoEvento = tipoEvento;
            return this;
        }
        
        public EventoBuilder local(String local){
            this.local = local;
            return this;
        }
        
        public EventoBuilder ministrante(String ministrante){
            this.ministrante = ministrante;
            return this;
        }
        
        public EventoBuilder participante(List<Participante> participante){
            this.participante = participante;
            return this;
        }
        
        public EventoBuilder periodos(Set<Periodo> periodos){
            this.periodos = periodos;
            return this;
        }
        
        public EventoBuilder organizacao(String organizacao){
            this.organizacao = organizacao;
            return this;
        }
         
        public EventoBuilder descricao(String descricao){
            this.descricao = descricao;
            return this;
        }
        
        public EventoBuilder valor(double valor){
            this.valor = valor;
            return this;
        }
        
        public EventoBuilder statusevento(boolean statusevento){
            this.statusevento = statusevento;
            return this;
        }
        
        public EventoBuilder titulo(String titulo){
            this.titulo = titulo;
            return this;
        }
        
        public EventoBuilder limite (Integer limite){
            this.limite = limite;
            return this;
        }
        public EventoBuilder disponivel (Integer disponivel){
            this.disponivel = disponivel;
            return this;
        }
        public Evento buildEvento(){
            System.out.println("no build evento");
            Evento evento = new Evento();
            evento.setTipoEvento(this.tipoEvento);
            evento.setLocal(this.local);
            evento.setPeriodos(this.periodos);
            evento.participante = new ArrayList<>();
            evento.setMinistrante(this.ministrante);
            evento.setOrganizacao(this.organizacao);
            evento.setTitulo(this.titulo);
            evento.setDescricao(this.descricao);
            evento.setValor(this.valor);
            evento.setStatusevento(this.statusevento);
            evento.setLimite(this.limite);
            evento.setDisponivel(this.disponivel);
            
            for (Periodo per: evento.getPeriodos()) {
              if (per.getId() != null){
                per.setEvento(evento);  
              }else{
               per.setEvento(evento);
               System.out.println("total =" + evento.periodos.size());
              }
            }
            
            return evento;
        }
    }
}
