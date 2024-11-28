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
@Table(name = "tb_compra_evento")
public class CompraEvento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "seq_compra_evento")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "evento_id", nullable = false)
    private Evento evento;

    @Column(name = "data_compra", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCompra;

    @Column(name = "quantidade_ingressos", nullable = false)
    private int quantidadeIngressos;

    @Column(name = "valor_total", nullable = false)
    private Double valorTotal;

    @Column(name = "avaliacao")
    private Integer avaliacao;
}
