package org.example.vo;

import java.util.Date;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entidade.Usuario;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UsuarioVO {

    private Long id;

    private String nome;

    private String email;

    private String telefone;

    private boolean ativo;

    private Date dataInicio;

    private Date dataFim;

    public UsuarioVO(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.telefone = usuario.getTelefone();
        this.ativo = usuario.isAtivo();
        this.dataInicio = usuario.getDataInicio();
        this.dataFim = usuario.getDataFim();
    }
}
