package com.projeto.basico.projetobasico.service;

import com.projeto.basico.projetobasico.model.Usuario;
import com.projeto.basico.projetobasico.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UsuarioService {
    @Autowired // auto gerencia CDI
    private UsuarioRepository usuarioRepository;

    public List<Usuario> buscarTodos() {
        return this.usuarioRepository.findAll();

    }
    public Usuario buscarPorId(Integer id) {
        return this.usuarioRepository.findById(id).orElse(null);
    }
    public Usuario inserirUsuario(Usuario usuario) {
      

        usuario.setId(null);
        return this.usuarioRepository.save(usuario);
    }
    public Usuario editarUsuario(Usuario usuario,Integer id) {
        usuario.setId(id);
        return this.usuarioRepository.save(usuario);
    }
    public void excluirUsuario(Integer id) {
        Usuario usuario = this.buscarPorId(id);
        this.usuarioRepository.delete(usuario);
    }
}
