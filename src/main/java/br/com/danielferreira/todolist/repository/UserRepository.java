package br.com.danielferreira.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.danielferreira.todolist.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
}
