package com.miguel.authenticationAPI.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UsersController {
     @GetMapping("/me")
    public ResponseEntity<String> ping() {

        return ResponseEntity.ok("API está funcionando! 🚀");
    }
    
    @PutMapping("/me")
    public ResponseEntity<String> modify() {

        return ResponseEntity.ok("API está funcionando! 🚀");
    }

    @DeleteMapping("/me")
    public ResponseEntity<String> delete() {

        return ResponseEntity.ok("API está funcionando! 🚀");
    }

}
