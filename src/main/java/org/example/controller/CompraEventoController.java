package org.example.controller;

import org.example.entidade.CompraEvento;
import org.example.service.CompraEventoService;
import org.example.vo.CompraEventoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/compra-eventos")
public class CompraEventoController {

    @Autowired
    private CompraEventoService compraEventoService;

    @GetMapping
    public List<CompraEventoVO> listarTodos() {
        return compraEventoService.listarTodos().stream()
                .map(CompraEventoVO::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/filtro")
    public List<CompraEventoVO> listarPorFiltro(@RequestParam(required = false) Long usuarioId,
                                                @RequestParam(required = false) Long eventoId) {
        return compraEventoService.listarPorFiltro(usuarioId, eventoId).stream()
                .map(CompraEventoVO::new)
                .collect(Collectors.toList());
    }

    @PostMapping
    public CompraEventoVO salvar(@RequestBody CompraEvento compraEvento) {
        CompraEvento compraEventoSalvo = compraEventoService.salvar(compraEvento);
        return new CompraEventoVO(compraEventoSalvo);
    }

    @PostMapping("/{id}/avaliacao")
    public void salvarAvaliacao(@PathVariable Long id, @RequestBody Integer avaliacao) {
        compraEventoService.salvarAvaliacao(id, avaliacao);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        compraEventoService.excluir(id);
    }
}
