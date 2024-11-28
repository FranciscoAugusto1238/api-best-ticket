package org.example.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entidade.Permissao;

import java.util.Date;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PermissaoVO {

    private Long id;
    private String nome;
    private Date dataFim;
    private String descricao;

    public PermissaoVO(Permissao permissao) {
        this.id = permissao.getId();
        this.nome = permissao.getNome();
        this.descricao = permissao.getDescricao();
        this.dataFim = permissao.getDataFim();
    }
}
