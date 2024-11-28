package org.example.entidade;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_evento")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "seq_evento")
    private Long id;

    @Column(name = "nome_evento", nullable = false, length = 100)
    private String nome;

    @Column(name = "descricao_evento", length = 255)
    private String descricao;

    @Column(name = "local_evento", nullable = false, length = 100)
    private String local;

    @Column(name = "data_inicio", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInicio;

    @Column(name = "data_fim")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataFim;

    @Column(name = "organizador", nullable = false, length = 100)
    private String organizador;

    @Column(name = "ativo", nullable = false)
    private boolean ativo = true;

    @Column(name = "valor")
    private String valor;
}
