package com.meire.poc.controller;

import com.meire.poc.model.Usuario;
import com.meire.poc.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> obterUsuarios(){
        return usuarioService.obterUsuarios();
    }

    @PostMapping
    public Usuario cadastrar(@RequestBody Usuario usuario){
        return usuarioService.cadastrarUsuario(usuario);
    }

}
