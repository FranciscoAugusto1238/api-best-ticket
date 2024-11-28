package org.example.service;

import org.example.entidade.Evento;
import org.example.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    public List<Evento> listarTodos() {
        return eventoRepository.findByDataFimIsNull();
    }

    public List<Evento> listarPorFiltro(String nome, String local) {
        if (nome != null && local != null) {
            return eventoRepository.findByNomeContainingAndLocalContainingAndDataFimIsNull(nome, local);
        } else if (nome != null) {
            return eventoRepository.findByNomeContainingAndDataFimIsNull(nome);
        } else if (local != null) {
            return eventoRepository.findByLocalContainingAndDataFimIsNull(local);
        }
        return eventoRepository.findByDataFimIsNull();
    }

    public Evento salvar(Evento evento) {
        if (evento.getDataInicio() == null) {
            evento.setDataInicio(new Date());
        }
        return eventoRepository.save(evento);
    }

    public void excluir(Long id) {
        Evento evento = eventoRepository.findById(id).orElseThrow(() -> new RuntimeException("Evento não encontrado"));
        evento.setDataFim(new Date());
        eventoRepository.save(evento);
    }
}
