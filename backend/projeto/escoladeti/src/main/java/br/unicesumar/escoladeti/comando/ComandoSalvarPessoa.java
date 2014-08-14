package br.unicesumar.escoladeti.comando;

import br.unicesumar.escoladeti.enums.Papel;
import br.unicesumar.escoladeti.enums.Sexo;
import br.unicesumar.escoladeti.enums.TipoTelefone;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

public class ComandoSalvarPessoa {

    private String nome;

    private String email;

    private String tipo;

    private String rg;

    private String cpf;

    private Date dataNascimento;

    private String sobrenome;

    private Sexo sexo;

    private Papel papel;

    private String cnpj;

    private String inscricaoEstadual;
    
    private String inscricaoMunicipal;
    
    private String razaoSocial;
    
    private Date dataCriacao;
}
