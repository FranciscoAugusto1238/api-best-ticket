package org.example.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entidade.AvaliacaoCurso;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AvaliacaoCursoVO {

    private Long id;
    private Long compraEvento;
    private Integer avaliacao;

    public AvaliacaoCursoVO(AvaliacaoCurso avaliacaoCurso) {
        this.id = avaliacaoCurso.getId();
        this.compraEvento = avaliacaoCurso.getCompraEvento().getId();
        this.avaliacao = avaliacaoCurso.getAvaliacao();
    }
}
