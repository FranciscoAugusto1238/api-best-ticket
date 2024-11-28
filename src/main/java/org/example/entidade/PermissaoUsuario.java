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
@Table(name = "tb_permissao_usuario")
public class PermissaoUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "seq_permissao_usuario")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "permissao_id", nullable = false)
    private Permissao permissao;

    @Column(name = "ativo", nullable = false)
    private boolean ativo = true;

    @Column(name = "data_inicio", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInicio;

    @Column(name = "data_fim")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataFim;
}
