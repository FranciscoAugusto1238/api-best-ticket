package org.example.repository;

import org.example.entidade.PermissaoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PermissaoUsuarioRepository extends JpaRepository<PermissaoUsuario, Long> {
    List<PermissaoUsuario> findByDataFimIsNotNull();
}
