package com.projeto.basico.projetobasico.resource;

import com.projeto.basico.projetobasico.model.Usuario;
import com.projeto.basico.projetobasico.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping // método get
    public ResponseEntity<List<Usuario>> buscarTodos() {
        return ResponseEntity.ok().body(usuarioService.buscarTodos());

    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok().body(usuarioService.buscarPorId(id));
    }
    @PostMapping
    public ResponseEntity<Usuario> inserirUsuario(@RequestBody Usuario usuario) {
        return ResponseEntity.created(null).body(usuarioService.inserirUsuario(usuario));
    }
    @PutMapping(value = "/{id}" )
    public ResponseEntity<Usuario> editarUsuario(@RequestBody Usuario usuario,@PathVariable Integer id) {
        return ResponseEntity.ok().body(usuarioService.editarUsuario(usuario,id));
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> excluirUsuario(@PathVariable Integer id) {
        usuarioService.excluirUsuario(id);
        return ResponseEntity.noContent().build();

    }


}
