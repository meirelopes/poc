package com.meire.poc.service;

import com.meire.poc.model.Usuario;
import com.meire.poc.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> obterUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario cadastrarUsuario(Usuario usuario){
        Usuario novoUsuario = new Usuario();
        novoUsuario.setNome(usuario.getNome());
        novoUsuario.setCpf(usuario.getCpf());
        usuarioRepository.save(novoUsuario);
        return novoUsuario;
    }
    public Usuario buscarUsuarioPorId(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario ==  null){
            return null;
        }
        return usuario.get();
    }

    public void deletarUsuario(Long id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario!=null){
            usuarioRepository.deleteById(id);
        }
    }
}
