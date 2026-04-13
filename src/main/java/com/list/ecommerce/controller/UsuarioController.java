package com.list.ecommerce.controller;

import com.list.ecommerce.dto.Requests.UsuarioRequest;
import com.list.ecommerce.dto.Response.UsuarioResponse;
import com.list.ecommerce.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController( UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    @PostMapping("/Usuario")
    public UsuarioResponse criarUsuario(@RequestBody UsuarioRequest usuarioRequest){

        return usuarioService.criarUsuario(usuarioRequest);
    }
    @PutMapping("/Usuario{id}")
    public UsuarioResponse atualizarUsuario(@RequestBody UsuarioRequest usuarioRequest,@PathVariable Integer id){

        return usuarioService.atualizarUsuario(id, usuarioRequest);
    }
    @GetMapping("/Usuarios{id}")
    public UsuarioResponse listarUsuarios(@PathVariable Integer id){

        return usuarioService.listarUsuarios(id);
    }
    @GetMapping("/Usuarios")
    public List<UsuarioResponse> listarTodosUsuarios(@PathVariable Integer id){
        return usuarioService.listarTodosUsuarios();
    }
    @DeleteMapping("/Usuario{id}")
    public void deletarUsuario(@PathVariable Integer id){
        usuarioService.deletarUsuario(id);
    }

}
