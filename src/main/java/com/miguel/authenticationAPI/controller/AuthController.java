package com.miguel.authenticationAPI.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.miguel.authenticationAPI.dto.authDto;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/ping")
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("API está funcionando! 🚀");
    }


    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody authDto usuario) {
        // Aqui você pode adicionar lógica para salvar no banco depois
        String mensagem = "Usuário " + usuario.getNome() + " registrado com sucesso!";
        return ResponseEntity.ok(mensagem);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody authDto usuario) {
        // Aqui você pode adicionar lógica para autenticar o usuário
        String mensagem = "Usuário " + usuario.getNome() + " logado com sucesso!";
        return ResponseEntity.ok(mensagem);
    }
     
    }

