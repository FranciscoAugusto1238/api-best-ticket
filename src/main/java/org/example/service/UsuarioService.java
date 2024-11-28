package org.example.service;

import org.example.entidade.Permissao;
import org.example.entidade.PermissaoUsuario;
import org.example.entidade.Role;
import org.example.entidade.Usuario;
import org.example.repository.RoleRepository;
import org.example.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PermissaoUsuarioService permissaoUsuarioService;

    public Optional<Usuario> buscarPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    public Usuario editar(Long id, Usuario usuario) {
        Usuario usuarioExistente = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (usuarioExistente.getDataFim() == null) {
            usuarioExistente.setNome(usuario.getNome());
            usuarioExistente.setEmail(usuario.getEmail());
            usuarioExistente.setSenha(usuario.getSenha());
            usuarioExistente.setTelefone(usuario.getTelefone());
            usuarioExistente.setAtivo(usuario.isAtivo());
        } else {
            // Definindo dataFim como a data atual para desativar o usuário
            usuarioExistente.setDataFim(new Date());
            usuarioExistente.setAtivo(false);
        }

        return usuarioRepository.save(usuarioExistente);
    }

    public List<Usuario> listarTodos() {
        return usuarioRepository.findByDataFimNull();
    }

    public List<Usuario> listarPorFiltro(String nome, String email) {
        if (nome != null && email != null) {
            return usuarioRepository.findByNomeContainingAndEmailContainingAndDataFimNull(nome, email);
        } else if (nome != null) {
            return usuarioRepository.findByNomeContainingAndDataFimNull(nome);
        } else if (email != null) {
            return usuarioRepository.findByEmailContainingAndDataFimNull(email);
        }
        return usuarioRepository.findByDataFimNull();
    }

    public Usuario salvar(Usuario usuario) {
        if (usuario.getDataInicio() == null) {
            usuario.setDataInicio(new Date());
            usuario.setAtivo(true);
        }

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String senhaCriptografada = passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(senhaCriptografada);

        Usuario usuarioSalvo = usuarioRepository.save(usuario);

        Permissao permissao = new Permissao();
        permissao.setId(2L);

        PermissaoUsuario permissaoUsuario = new PermissaoUsuario();
        permissaoUsuario.setUsuario(usuarioSalvo);
        permissaoUsuario.setPermissao(permissao);
        permissaoUsuario.setDataInicio(new Date());

        permissaoUsuarioService.salvar(permissaoUsuario);

        return usuarioSalvo;
    }

    public void excluir(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        usuario.setDataFim(new Date());
        usuario.setAtivo(false);
        usuarioRepository.save(usuario);
    }

    public Usuario criarUsuarioComRoles(Usuario usuario, Set<String> roleNames) {
        Set<Role> roles = new HashSet<>();
        for (String roleName : roleNames) {
            Role role = roleRepository.findByRoleName(roleName);
            if (role == null) {
                role = new Role();
                role.setRoleName(roleName);
                roleRepository.save(role);
            }
            roles.add(role);
        }
        usuario.setRoles(roles);
        return usuarioRepository.save(usuario);
    }
}
