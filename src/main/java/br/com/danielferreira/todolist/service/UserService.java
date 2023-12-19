package br.com.danielferreira.todolist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.danielferreira.todolist.entity.User;
import br.com.danielferreira.todolist.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    UserRepository userRepository;

    public List<User> create(User user){
        userRepository.save(user);
        return list();
    }

     public List<User> list(){
        Sort sort = Sort.by("name").ascending();
        return userRepository.findAll(sort);
    }

     public List<User> update(User user){
        userRepository.save(user);
        return list();
    }

     public List<User> delete(Long id){
        userRepository.deleteById(id);
        return list();
    }
}
