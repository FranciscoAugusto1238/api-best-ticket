package org.example.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entidade.CompraEvento;

import java.util.Date;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CompraEventoVO {

    private Long id;

    private Long usuarioId;

    private String usuarioNome;

    private Long eventoId;

    private String eventoNome;

    private Date dataCompra;

    private int quantidadeIngressos;

    private Double valorTotal;
    private Integer avaliacao;

    public CompraEventoVO(CompraEvento compraEvento) {
        this.id = compraEvento.getId();
        this.usuarioId = compraEvento.getUsuario().getId();
        this.usuarioNome = compraEvento.getUsuario().getNome();
        this.eventoId = compraEvento.getEvento().getId();
        this.eventoNome = compraEvento.getEvento().getNome();
        this.dataCompra = compraEvento.getDataCompra();
        this.quantidadeIngressos = compraEvento.getQuantidadeIngressos();
        this.valorTotal = compraEvento.getValorTotal();
        this.avaliacao = compraEvento.getAvaliacao();
    }
}
