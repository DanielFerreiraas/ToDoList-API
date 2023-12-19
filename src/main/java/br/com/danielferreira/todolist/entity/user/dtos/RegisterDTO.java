package br.com.danielferreira.todolist.entity.user.dtos;

import br.com.danielferreira.todolist.entity.user.UserRole;

public record RegisterDTO(String name, String email, String password, UserRole role) {
    
}
