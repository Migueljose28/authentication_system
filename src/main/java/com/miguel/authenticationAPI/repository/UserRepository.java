package com.miguel.authenticationAPI.repository;

import com.miguel.authenticationAPI.model.Usuario;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Usuario, Long> {
    
    // Consulta para login (usada no service)
    Usuario findByEmail(String email);

    // Verifica se já existe um usuário com esse email
    boolean existsByEmail(String email);

    // Método para buscar usuário por ID
    Optional<Usuario> findById(Long id); 
}
