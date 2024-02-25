package com.meire.poc.controller;

import com.meire.poc.model.Usuario;
import com.meire.poc.service.UsuarioService;
import com.meire.poc.util.ExecutionTimeHolder;
import com.meire.poc.util.MdcInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final Logger logger = LoggerFactory.getLogger(UsuarioController.class);

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> obterUsuarios(){

        List<Usuario> usuarios = usuarioService.obterUsuarios();
        logger.error("Mensagem de erro: ");
        return usuarios;
    }

    @PostMapping
    public Usuario cadastrar(@RequestBody Usuario usuario){
        Usuario usuarioCadastrado = usuarioService.cadastrarUsuario(usuario);

        logger.info("Usuário cadastrado com sucesso: {}", usuarioCadastrado);
        return usuarioCadastrado;
    }
    @DeleteMapping("/{id}")
    public void deletarUsuario(@PathVariable Long id) {
        try {
            Usuario usuario = usuarioService.buscarUsuarioPorId(id);
            usuarioService.deletarUsuario(id);
        } catch (NoSuchElementException e) {
            // Tratamento da exceção
            logger.error("Ocorreu uma exceção ao buscar o usuário por ID: {}", e.getMessage());
        }

    }

}
