package org.example.repository;

import org.example.entidade.CompraEvento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompraEventoRepository extends JpaRepository<CompraEvento, Long> {

    List<CompraEvento> findByUsuarioId(Long usuarioId);

    List<CompraEvento> findByEventoId(Long eventoId);

    List<CompraEvento> findByUsuarioIdAndEventoId(Long usuarioId, Long eventoId);
}
