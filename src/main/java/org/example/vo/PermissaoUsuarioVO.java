package org.example.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entidade.PermissaoUsuario;

import java.util.Date;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PermissaoUsuarioVO {

    private Long id;
    private Long usuarioId;
    private String usuarioNome;
    private Long permissaoId;
    private String permissaoNome;
    private Date dataInicio;
    private Date dataFim;

    private boolean ativo;

    public PermissaoUsuarioVO(PermissaoUsuario permissaoUsuario) {
        this.id = permissaoUsuario.getId();
        this.usuarioId = permissaoUsuario.getUsuario().getId();
        this.usuarioNome = permissaoUsuario.getUsuario().getNome();
        this.permissaoId = permissaoUsuario.getPermissao().getId();
        this.permissaoNome = permissaoUsuario.getPermissao().getNome();
        this.ativo = permissaoUsuario.isAtivo();
        this.dataFim = permissaoUsuario.getPermissao().getDataFim();
    }
}
