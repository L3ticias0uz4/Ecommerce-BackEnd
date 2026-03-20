package com.list.ecommerce.service;

import com.list.ecommerce.dto.Request.UsuarioRequest;
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

    //Post
    public UsuarioResponse criarUsuario(UsuarioRequest usuarioRequest) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findByEmail(usuarioRequest.getEmail());
        if (usuarioExistente.isPresent()) {
            throw new RuntimeException("Email ja registrado");
        }
        Usuario usuario = new Usuario();
        usuario.setEmail(usuarioRequest.getEmail());
        usuario.setNome(usuarioRequest.getNome());
        usuario.setTelefone(usuarioRequest.getTelefone());
        usuario.setSenha(usuarioRequest.getSenha());
        usuario.setRoles(usuarioRequest.getRoles());
        usuarioRepository.save(usuario);

        UsuarioResponse usuarioResponse = new UsuarioResponse(
                usuario.getId(),
                usuario.getTelefone(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getPedidos()
        );
        return usuarioResponse;


    }

    public List<UsuarioResponse> listarTodosUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream().map(usuario -> new UsuarioResponse(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getTelefone(),
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
                usuario.getPedidos()
        );
    }

    public void deletarUsuario(Integer id) {

     Usuario usuario =  usuarioRepository.findById(id).orElseThrow(()-> new RuntimeException("Usuario não encontrado"));
     usuarioRepository.delete(usuario);
    }

    public UsuarioResponse atualizarUsuario(Integer id,UsuarioRequest usuarioRequest) {

        Usuario usuario = usuarioRepository.findById(id).orElseThrow(()-> new RuntimeException("Usuario não encontrado"));
        usuario.setNome(usuarioRequest.getNome());
        usuario.setEmail(usuarioRequest.getEmail());
        usuario.setTelefone(usuarioRequest.getTelefone());
        usuario.setSenha(usuarioRequest.getSenha());
        UsuarioResponse usuarioResponse = new UsuarioResponse(
                usuario.getId(),
                usuario.getNome(),
                usuario.getTelefone(),
                usuario.getEmail(),
                usuario.getPedidos()
        );
          return usuarioResponse;
    }

}
