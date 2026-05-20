package com.list.ecommerce.controller;

import com.list.ecommerce.dto.Requests.UsuarioRequest;
import com.list.ecommerce.dto.Response.UsuarioResponse;
import com.list.ecommerce.service.PhotoService;
import com.list.ecommerce.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/Usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final PhotoService photoService;

    public UsuarioController(UsuarioService usuarioService, PhotoService photoService) {
        this.usuarioService = usuarioService;
        this.photoService = photoService;
    }

    @PostMapping("/Usuario")
    public ResponseEntity<UsuarioResponse> criarUsuario(
            @RequestParam String nome,
            @RequestParam String email,
            @RequestParam String senha,
            @RequestParam(required = false) String telefone,
            @RequestParam(required = false) MultipartFile foto) throws IOException {

        UsuarioRequest usuarioRequest = new UsuarioRequest();
        usuarioRequest.setNome(nome);
        usuarioRequest.setEmail(email);
        usuarioRequest.setSenha(senha);
        usuarioRequest.setTelefone(telefone);

        String caminhoFoto = null;
        if (foto != null && !foto.isEmpty()) {
            caminhoFoto = photoService.salvarFoto(foto);
        }

        return ResponseEntity.ok(usuarioService.criarUsuario(usuarioRequest, caminhoFoto));
    }

    @PutMapping("/Usuario/{id}")
    public ResponseEntity<UsuarioResponse> atualizarUsuario(
            @PathVariable Integer id,
            @RequestParam String nome,
            @RequestParam String email,
            @RequestParam String senha,
            @RequestParam(required = false) String telefone,
            @RequestParam(required = false) MultipartFile foto) throws IOException {

        UsuarioRequest usuarioRequest = new UsuarioRequest();
        usuarioRequest.setNome(nome);
        usuarioRequest.setEmail(email);
        usuarioRequest.setSenha(senha);
        usuarioRequest.setTelefone(telefone);

        String caminhoFoto = null;
        if (foto != null && !foto.isEmpty()) {
            caminhoFoto = photoService.salvarFoto(foto);
        }

        return ResponseEntity.ok(usuarioService.atualizarUsuario(id, usuarioRequest, caminhoFoto));
    }

    @GetMapping("/Usuario/{id}")
    public ResponseEntity<UsuarioResponse> listarUsuarios(@PathVariable Integer id) {
        return ResponseEntity.ok(usuarioService.listarUsuarios(id));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> listarTodosUsuarios() {
        return ResponseEntity.ok(usuarioService.listarTodosUsuarios());
    }

    @DeleteMapping("/Usuario/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Integer id) {
        usuarioService.deletarUsuario(id);
        return ResponseEntity.noContent().build();
    }
}