package org.example.controller;

import org.example.entidade.PermissaoUsuario;
import org.example.service.PermissaoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permissao-usuario")
@CrossOrigin(origins = "http://localhost:8081")
public class PermissaoUsuarioController {

    @Autowired
    private PermissaoUsuarioService permissaoUsuarioService;

    @PostMapping("/salvar")
    public ResponseEntity<PermissaoUsuario> salvar(@RequestBody PermissaoUsuario permissaoUsuario) {
        PermissaoUsuario salvo = permissaoUsuarioService.salvar(permissaoUsuario);
        return ResponseEntity.ok(salvo);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<PermissaoUsuario> editar(@PathVariable Long id, @RequestBody PermissaoUsuario permissaoUsuario) {
        permissaoUsuario.setId(id);
        PermissaoUsuario editado = permissaoUsuarioService.editar(permissaoUsuario);
        return ResponseEntity.ok(editado);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        permissaoUsuarioService.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/pesquisar")
    public ResponseEntity<List<PermissaoUsuario>> pesquisar() {
        List<PermissaoUsuario> permissaoUsuarios = permissaoUsuarioService.pesquisar();
        return ResponseEntity.ok(permissaoUsuarios);
    }

    @GetMapping("/pesquisar-filtro")
    public ResponseEntity<List<PermissaoUsuario>> pesquisarPorFiltro() {
        List<PermissaoUsuario> permissaoUsuarios = permissaoUsuarioService.pesquisarPorFiltro();
        return ResponseEntity.ok(permissaoUsuarios);
    }
}
