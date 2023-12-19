package br.com.danielferreira.todolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.danielferreira.todolist.entity.User;
import br.com.danielferreira.todolist.service.UserService;



@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    List<User> create(@RequestBody User user) {
        return userService.create(user);
    }

    @GetMapping
    List<User> list() {
        return userService.list();
    }

    @PutMapping
    List<User> update(@RequestBody User user) {
        return userService.update(user);
    }

    
    @DeleteMapping("{id}")
    List<User> delete(@PathVariable("id") Long id) {
        return userService.delete(id);
    }
    
}
