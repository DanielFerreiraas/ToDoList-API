package br.com.danielferreira.todolist.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.danielferreira.todolist.entity.user.User;

public interface UserRepository extends JpaRepository<User, String>{
    
    UserDetails findByName(String name);
    
}
