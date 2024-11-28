package org.example.repository;

import org.example.entidade.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventoRepository extends JpaRepository<Evento, Long> {

    List<Evento> findByDataFimIsNull();

    List<Evento> findByNomeContainingAndLocalContainingAndDataFimIsNull(String nome, String local);

    List<Evento> findByNomeContainingAndDataFimIsNull(String nome);

    List<Evento> findByLocalContainingAndDataFimIsNull(String local);
}
