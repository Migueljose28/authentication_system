package com.miguel.authenticationAPI.dto;

public class registerDto {
    private String nome;
    private String email;
    private String senha;


 // Getters e setters
 public String getNome() {
    return nome;
}


public String getSenha() {
    return senha;
}


public String getEmail() {
    return email;
}   

public void setEmail(String email) {
    this.email = email;
}       

public void setSenha(String senha) {
    this.senha = senha;
}

public void setNome(String nome) {
    this.nome = nome;
}

}
