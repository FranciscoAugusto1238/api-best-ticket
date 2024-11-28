package org.example.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entidade.Evento;

import java.util.Date;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventoVO {

    private Long id;
    private String nome;
    private String descricao;
    private String local;
    private Date dataInicio;
    private Date dataFim;
    private String organizador;
    private boolean ativo;
    private String valor;

    public EventoVO(Evento evento) {
        this.id = evento.getId();
        this.nome = evento.getNome();
        this.descricao = evento.getDescricao();
        this.local = evento.getLocal();
        this.dataInicio = evento.getDataInicio();
        this.dataFim = evento.getDataFim();
        this.organizador = evento.getOrganizador();
        this.ativo = evento.isAtivo();
        this.valor = evento.getValor();
    }
}
