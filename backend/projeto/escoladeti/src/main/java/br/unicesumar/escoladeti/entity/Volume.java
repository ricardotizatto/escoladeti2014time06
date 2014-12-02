package br.unicesumar.escoladeti.entity;

import br.unicesumar.escoladeti.comando.ComandoSalvarVolume;
import br.unicesumar.escoladeti.enums.Transcricao;
import br.unicesumar.escoladeti.enums.VolumeStatus;
import br.unicesumar.escoladeti.util.string.StringUtils;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.File;
import java.util.Date;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Volume  {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "transcricao")
    private Transcricao transcricao;

    @ManyToOne
    @JoinColumn(name = "id_responsavel")
    private Usuario responsavel;

    @Column(name = "pagina_inicio")
    private Integer paginaInicio;

    @Column(name = "pagina_fim")
    private Integer paginaFim;

    @Enumerated(EnumType.STRING)
    private VolumeStatus status;

    @Column(name = "caminho_anexo")
    private String caminhoAnexo;

    @Column(name = "data_criacao")
    private Date dataCriacao;

    @Column(name = "id_livro")
    private Long idLivro;

    @Column(name = "data_alteracao")
    private Date dataAlteracao;

    private String outro;

    public Volume() {
        this.dataCriacao = new Date();
    }

    public Usuario getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Usuario responsavel) {
        this.responsavel = responsavel;
    }

    public Integer getPaginaInicio() {
        return paginaInicio;
    }

    public void setPaginaInicio(Integer paginaInicio) {
        this.paginaInicio = paginaInicio;
    }

    public Integer getPaginaFim() {
        return paginaFim;
    }

    public void setPaginaFim(Integer paginaFim) {
        this.paginaFim = paginaFim;
    }

    public VolumeStatus getStatus() {
        return status;
    }

    public void setStatus(VolumeStatus status) {
        this.status = status;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(Date dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCaminhoAnexo() {
        return caminhoAnexo;
    }

    public Long getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(Long idLivro) {
        this.idLivro = idLivro;
    }

    public String getNomeArquivo() {
        if (StringUtils.isNotEmpty(caminhoAnexo))
            return new File(getCaminhoAnexo()).getName();

        return "";
    }

    public Transcricao getTranscricao() {
        return transcricao;
    }

    public void setTranscricao(Transcricao transcricao) {
        this.transcricao = transcricao;
    }

    public void setCaminhoAnexo(String caminhoAnexo) {
        this.caminhoAnexo = caminhoAnexo;
    }


    public void concluir(ComandoSalvarVolume comandoSalvarVolume) {
        if (!status.equals(VolumeStatus.ANDAMENTO)) {
            throw new RuntimeException("Sómente volume em andamento pode ser concluido");
        }

        if(caminhoAnexo == null) {
            throw new RuntimeException("Arquivo é obrigatório para concluir volume");
        }

        setDataAlteracao(new Date());
        setStatus(VolumeStatus.CONCLUIDO);
    }

    public void reativar() {
        setStatus(VolumeStatus.ANDAMENTO);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || ! (o instanceof Volume)){
            return false;
        }

        Volume volume = (Volume) o;

        return volume.getId().equals(this.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    public void alterarDataAlteracao() {
        dataAlteracao = new Date();
    }

    public String getOutro() {
        return outro;
    }

    public void setOutro(String outro) {
        this.outro = outro;
    }
}
