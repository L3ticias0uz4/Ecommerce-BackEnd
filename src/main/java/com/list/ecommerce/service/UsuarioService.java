package com.list.ecommerce.service;

import com.list.ecommerce.dto.Requests.UsuarioRequest;
import com.list.ecommerce.dto.Response.UsuarioResponse;
import com.list.ecommerce.entity.Usuario;
import com.list.ecommerce.repository.UsuarioRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioResponse criarUsuario(UsuarioRequest usuarioRequest, String caminhoFoto) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findByEmail(usuarioRequest.getEmail());
        if (usuarioExistente.isPresent()) {
            throw new RuntimeException("Email já registrado");
        }
        Usuario usuario = new Usuario();
        usuario.setEmail(usuarioRequest.getEmail());
        usuario.setNome(usuarioRequest.getNome());
        usuario.setTelefone(usuarioRequest.getTelefone());
        usuario.setSenha(usuarioRequest.getSenha());
        usuario.setFoto(caminhoFoto);
        usuarioRepository.save(usuario);

        return new UsuarioResponse(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getTelefone(),
                usuario.getFoto(),
                usuario.getPedidos()
        );
    }

    public List<UsuarioResponse> listarTodosUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream().map(usuario -> new UsuarioResponse(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getTelefone(),
                usuario.getFoto(),
                usuario.getPedidos()
        )).toList();
    }

    public UsuarioResponse listarUsuarios(Integer id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow();
        return new UsuarioResponse(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getTelefone(),
                usuario.getFoto(),
                usuario.getPedidos()
        );
    }

    public void deletarUsuario(Integer id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
        usuarioRepository.delete(usuario);
    }

    public UsuarioResponse atualizarUsuario(Integer id, UsuarioRequest usuarioRequest, String caminhoFoto) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
        usuario.setNome(usuarioRequest.getNome());
        usuario.setEmail(usuarioRequest.getEmail());
        usuario.setTelefone(usuarioRequest.getTelefone());
        usuario.setSenha(usuarioRequest.getSenha());
        if (caminhoFoto != null && !caminhoFoto.isBlank()) {
            usuario.setFoto(caminhoFoto);
        }
        usuarioRepository.save(usuario);

        return new UsuarioResponse(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getTelefone(),
                usuario.getFoto(),
                usuario.getPedidos()
        );
    }
}