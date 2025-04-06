package com.miguel.authenticationAPI.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.miguel.authenticationAPI.service.UserService;
import com.miguel.authenticationAPI.dto.registerDto;
import com.miguel.authenticationAPI.model.Usuario;


@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserService userService;



     @GetMapping("/me")
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        List<Usuario> usuarios = userService.listarUsuarios();
        return ResponseEntity.ok(usuarios);
    }
    
    
    @PutMapping("/me/{id}")
    public ResponseEntity<Usuario> modify(@PathVariable Long id, @RequestBody registerDto dto) {
        Usuario usuario = userService.buscarPorId(id);
        if(usuario == null) {
            return ResponseEntity.notFound().build();
        }
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha()); // depois colocamos o hash aqui!
        // Aqui você pode adicionar lógica para atualizar o usuário no banco de dados
        // userService.update(usuario); // Supondo que você tenha um método update no UserService
        // Retorna o usuário atualizado
        return ResponseEntity.ok(usuario);
        
        
    }

    @DeleteMapping("/me/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return ResponseEntity.ok("Quase deletado com sucesso" + id);
    }

}
