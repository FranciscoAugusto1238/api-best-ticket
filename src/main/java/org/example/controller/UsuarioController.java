package org.example.controller;

import org.example.entidade.Usuario;
import org.example.service.UsuarioService;
import org.example.vo.UsuarioVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioVO> listarTodos() {
        return usuarioService.listarTodos().stream()
                .map(UsuarioVO::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/filtro")
    public List<UsuarioVO> listarPorFiltro(@RequestParam(required = false) String nome,
                                           @RequestParam(required = false) String email) {
        return usuarioService.listarPorFiltro(nome, email).stream()
                .map(UsuarioVO::new)
                .collect(Collectors.toList());
    }

    @PostMapping
    public UsuarioVO salvar(@RequestBody Usuario usuario) {
        Usuario usuarioSalvo = usuarioService.salvar(usuario);
        return new UsuarioVO(usuarioSalvo);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        usuarioService.excluir(id);
    }

    @PutMapping("/{id}")
    public UsuarioVO editar(@PathVariable Long id, @RequestBody Usuario usuario) {
        // Atualizar o usuário
        Usuario usuarioAtualizado = usuarioService.editar(id, usuario);
        return new UsuarioVO(usuarioAtualizado);
    }

    @PostMapping("/login")
    public UsuarioVO login(@RequestBody Usuario usuario) {
        Optional<Usuario> usuarioExistente = usuarioService.buscarPorEmail(usuario.getEmail());

        if (usuarioExistente.isPresent()) {
            Usuario usuarioNoBanco = usuarioExistente.get();

            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

            if (passwordEncoder.matches(usuario.getSenha(), usuarioNoBanco.getSenha())) {
                return new UsuarioVO(usuarioNoBanco);
            }
        }

        throw new RuntimeException("Email ou senha inválidos");
    }
}
