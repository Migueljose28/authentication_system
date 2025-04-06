
package com.miguel.authenticationAPI.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.miguel.authenticationAPI.model.Usuario;
//import com.miguel.authenticationAPI.dto.*;
import com.miguel.authenticationAPI.repository.UserRepository;

@Service
public class UserService{
    @Autowired
    private UserRepository userRepository;

    public boolean register(Usuario user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            return false; // Já existe usuário com esse e-mail
        }

        userRepository.save(user); // Salva no banco
        return true;
    }

    public List<Usuario> listarUsuarios() {
        return userRepository.findAll(); // Busca todos no banco
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    
    public Usuario buscarPorId(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }


}


    