package org.example.repository;

import org.example.entidade.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    List<Usuario> findByDataFimNull();
    List<Usuario> findByNomeContainingAndEmailContainingAndDataFimNull(String nome, String email);
    List<Usuario> findByNomeContainingAndDataFimNull(String nome);
    List<Usuario> findByEmailContainingAndDataFimNull(String email);

    Optional<Usuario> findByEmail(String email);

}
