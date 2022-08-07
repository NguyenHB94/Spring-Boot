package com.example.springday05.service;

import com.example.springday05.model.Todo;
import com.example.springday05.repository.TodosRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TodosService {
    private final TodosRepository todosRepository;

    public TodosService(TodosRepository todosRepository) {
        this.todosRepository = todosRepository;
    }

    public List<Todo> getAll() {
        return this.todosRepository.findAll();
    }

    public List<Todo> getTodosByStatus(Boolean status) {
        return this.todosRepository.getByStatus(status);
    }

    public Todo getTodoById(Integer id) {
        var todo = this.todosRepository.findById(id);
        return todo.orElse(null);
    }

    public Todo createNewTodo(Todo newTodo) {
        return this.todosRepository.save(newTodo);
    }

    public Todo updateTodo(Todo newTodo, Integer id) {
        return  this.todosRepository.save(newTodo);
    }

    public void deleteTodo(Integer id) {
        this.todosRepository.deleteById(id);
    }
}
