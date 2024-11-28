package org.example.controller;

import org.example.entidade.Permissao;
import org.example.service.PermissaoService;
import org.example.vo.PermissaoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/permissoes")
public class PermissaoController {

    @Autowired
    private PermissaoService permissaoService;

    @GetMapping
    public List<PermissaoVO> listarTodas() {
        return permissaoService.listarTodas().stream()
                .map(PermissaoVO::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/filtro")
    public List<PermissaoVO> listarPorFiltro(@RequestParam(required = false) String nome) {
        return permissaoService.listarPorFiltro(nome).stream()
                .map(PermissaoVO::new)
                .collect(Collectors.toList());
    }

    @PostMapping
    public PermissaoVO salvar(@RequestBody Permissao permissao) {
        Permissao permissaoSalva = permissaoService.salvar(permissao);
        return new PermissaoVO(permissaoSalva);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        permissaoService.excluir(id);
    }
}
