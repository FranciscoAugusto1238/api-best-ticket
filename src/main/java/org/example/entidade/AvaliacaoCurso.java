package org.example.entidade;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "avaliacao_curso")
public class AvaliacaoCurso {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_avaliacao")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "compra_evento_id", nullable = false)
    private CompraEvento compraEvento;

    @Column(name = "avaliacao", nullable = false)
    private Integer avaliacao;
}
