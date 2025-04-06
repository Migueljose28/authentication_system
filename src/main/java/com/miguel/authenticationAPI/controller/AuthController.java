package com.miguel.authenticationAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.miguel.authenticationAPI.dto.*;
import com.miguel.authenticationAPI.service.*;
import com.miguel.authenticationAPI.model.Usuario;

@RestController
@RequestMapping("/auth")

public class AuthController {

    @Autowired
    private UserService userService;



    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody registerDto dto) {
        // Aqui você pode adicionar lógica para salvar no banco depois
        Usuario novoUsuario = new Usuario();
        novoUsuario.setNome(dto.getNome());
        novoUsuario.setEmail(dto.getEmail());
        novoUsuario.setSenha(dto.getSenha()); // depois colocamos o hash aqui!
    
        boolean registrado = userService.register(novoUsuario);

        if (registrado ) {
            return ResponseEntity.ok("Usuário registrado com sucesso!");
        } else {
            return ResponseEntity.badRequest().body("Erro: E-mail já cadastrado.");
        }
    }

   
    

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody loginDto usuario) {
        // Aqui você pode adicionar lógica para autenticar o usuário
        String mensagem = "Usuário " + usuario.getNome() + " logado com sucesso!";
        return ResponseEntity.ok(mensagem);
    }
         

}