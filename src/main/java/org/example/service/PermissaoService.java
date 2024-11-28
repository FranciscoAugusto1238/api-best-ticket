package org.example.service;

import org.example.entidade.Permissao;
import org.example.repository.PermissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissaoService {

    @Autowired
    private PermissaoRepository permissaoRepository;

    // Listar todas as permissões
    public List<Permissao> listarTodas() {
        return permissaoRepository.findAll();
    }

    // Listar permissões por filtro (nome)
    public List<Permissao> listarPorFiltro(String nome) {
        if (nome != null) {
            return permissaoRepository.findByNomeContaining(nome);
        }
        return permissaoRepository.findAll();
    }

    // Salvar ou atualizar permissão
    public Permissao salvar(Permissao permissao) {
        return permissaoRepository.save(permissao);
    }

    // Excluir permissão por ID
    public void excluir(Long id) {
        permissaoRepository.deleteById(id);
    }
}
