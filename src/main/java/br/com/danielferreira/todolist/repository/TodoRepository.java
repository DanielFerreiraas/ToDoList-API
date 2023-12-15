package br.com.danielferreira.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.danielferreira.todolist.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long>{
    
}
