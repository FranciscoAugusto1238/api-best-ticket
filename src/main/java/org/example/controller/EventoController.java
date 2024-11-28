package org.example.controller;

import org.example.entidade.Evento;
import org.example.service.EventoService;
import org.example.vo.EventoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @GetMapping
    public List<EventoVO> listarTodos() {
        return eventoService.listarTodos().stream()
                .map(EventoVO::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/filtro")
    public List<EventoVO> listarPorFiltro(@RequestParam(required = false) String nome,
                                          @RequestParam(required = false) String local) {
        return eventoService.listarPorFiltro(nome, local).stream()
                .map(EventoVO::new)
                .collect(Collectors.toList());
    }

    @PostMapping
    public EventoVO salvar(@RequestBody Evento evento) {
        Evento eventoSalvo = eventoService.salvar(evento);
        return new EventoVO(eventoSalvo);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        eventoService.excluir(id);
    }
}
