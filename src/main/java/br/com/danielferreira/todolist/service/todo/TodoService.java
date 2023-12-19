package br.com.danielferreira.todolist.service.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.danielferreira.todolist.entity.todo.Todo;
import br.com.danielferreira.todolist.repository.todo.TodoRepository;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> create(Todo todo){
        todoRepository.save(todo);
        return list();
    }

     public List<Todo> list(){
        Sort sort = Sort.by("prioridade").descending().and(Sort.by("nome").ascending());
        return todoRepository.findAll(sort);
    }

     public List<Todo> update(Todo todo){
        todoRepository.save(todo);
        return list();
    }

     public List<Todo> delete(String id){
        todoRepository.deleteById(id);
        return list();
    }
    
}
