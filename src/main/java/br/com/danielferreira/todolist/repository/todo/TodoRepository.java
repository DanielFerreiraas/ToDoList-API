package br.com.danielferreira.todolist.repository.todo;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.danielferreira.todolist.entity.todo.Todo;

public interface TodoRepository extends JpaRepository<Todo, String>{
    
}
