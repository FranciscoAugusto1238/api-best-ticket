package org.example.entidade;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "seq_usuario")
    private Long id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "email", nullable = false, unique = true, length = 150)
    private String email;

    @Column(name = "senha", nullable = false)
    private String senha;

    @Column(name = "telefone", length = 15)
    private String telefone;

    @Column(name = "ativo", nullable = false)
    private boolean ativo;

    @Column(name = "data_inicio", nullable = false)
    private Date dataInicio;

    @Column(name = "data_fim")
    private Date dataFim;

    public void setRoles(Set<Role> roles) {
    }
}
