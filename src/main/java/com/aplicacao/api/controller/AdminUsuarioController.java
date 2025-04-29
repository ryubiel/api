package com.aplicacao.api.controller;

import com.aplicacao.api.model.Acesso;
import com.aplicacao.api.model.Usuario;
import com.aplicacao.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminUsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void deletarUsuario(@PathVariable Long id) {
        usuarioRepository.deleteById(id);
    }

    // Endpoint para promover um usuário a ADMIN
    @PatchMapping("/promover/{id}")
    public Usuario promoverParaAdmin(@PathVariable Long id) {
        return usuarioRepository.findById(id).map(usuario -> {
            usuario.setAcesso(Acesso.valueOf("ADMIN"));
            return usuarioRepository.save(usuario);
        }).orElse(null);
    }

}