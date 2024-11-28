package org.example.service;

import org.example.entidade.PermissaoUsuario;
import org.example.repository.PermissaoUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PermissaoUsuarioService {

    @Autowired
    private PermissaoUsuarioRepository permissaoUsuarioRepository;

    public PermissaoUsuario salvar(PermissaoUsuario permissaoUsuario) {
        if (permissaoUsuario.getDataInicio() == null) {
            permissaoUsuario.setDataInicio(new Date());
        }
        return permissaoUsuarioRepository.save(permissaoUsuario);
    }

    public PermissaoUsuario editar(PermissaoUsuario permissaoUsuario) {
        Optional<PermissaoUsuario> permissaoUsuarioExistente = permissaoUsuarioRepository.findById(permissaoUsuario.getId());
        if (permissaoUsuarioExistente.isPresent()) {
            return permissaoUsuarioRepository.save(permissaoUsuario);
        }
        throw new RuntimeException("Permissão de usuário não encontrada.");
    }

    public void excluir(Long id) {
        Optional<PermissaoUsuario> permissaoUsuario = permissaoUsuarioRepository.findById(id);
        if (permissaoUsuario.isPresent()) {
            PermissaoUsuario usuario = permissaoUsuario.get();
            if (usuario.getDataFim() == null) {
                usuario.setDataFim(new Date());
            }
            permissaoUsuarioRepository.save(usuario);
        } else {
            throw new RuntimeException("Permissão de usuário não encontrada.");
        }
    }

    public List<PermissaoUsuario> pesquisar() {
        return permissaoUsuarioRepository.findAll();
    }

    public List<PermissaoUsuario> pesquisarPorFiltro() {
        return permissaoUsuarioRepository.findByDataFimIsNotNull();
    }
}
