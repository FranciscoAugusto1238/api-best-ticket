package org.example.service;

import org.example.entidade.AvaliacaoCurso;
import org.example.entidade.CompraEvento;
import org.example.repository.AvaliacoesCursoRepository;
import org.example.repository.CompraEventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CompraEventoService {

    @Autowired
    private CompraEventoRepository compraEventoRepository;

    @Autowired
    private AvaliacoesCursoRepository avaliacoesCursoRepository;

    public List<CompraEvento> listarTodos() {
        return compraEventoRepository.findAll();
    }

    public void avaliarCompra(Long id, Integer avaliacao) {
        CompraEvento compraEvento = compraEventoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Compra não encontrada com o ID: " + id));

        if (avaliacao < 1 || avaliacao > 5) {
            throw new IllegalArgumentException("A avaliação deve ser entre 1 e 5 estrelas.");
        }

        compraEvento.setAvaliacao(avaliacao);
        compraEventoRepository.save(compraEvento);
    }

    public void salvarAvaliacao(Long compraEventoId, Integer avaliacao) {
        CompraEvento compraEvento = compraEventoRepository.findById(compraEventoId)
                .orElseThrow(() -> new IllegalArgumentException("Compra do evento não encontrada"));
        compraEvento.setAvaliacao(avaliacao);
        compraEventoRepository.save(compraEvento);
    }

    public List<CompraEvento> listarPorFiltro(Long usuarioId, Long eventoId) {
        if (usuarioId != null && eventoId != null) {
            return compraEventoRepository.findByUsuarioIdAndEventoId(usuarioId, eventoId);
        } else if (usuarioId != null) {
            return compraEventoRepository.findByUsuarioId(usuarioId);
        } else if (eventoId != null) {
            return compraEventoRepository.findByEventoId(eventoId);
        }
        return compraEventoRepository.findAll();
    }

    // Salvar ou atualizar compra de evento
    public CompraEvento salvar(CompraEvento compraEvento) {
        if (compraEvento.getDataCompra() == null) {
            compraEvento.setDataCompra(new Date());
        }
        return compraEventoRepository.save(compraEvento);
    }

    // Excluir compra de evento por ID
    public void excluir(Long id) {
        compraEventoRepository.deleteById(id);
    }
}
