package com.example.springday04.service;

import com.example.springday04.model.Todo;
import com.example.springday04.reposistory.TodoReposistory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    TodoReposistory todoReposistory;

    public TodoService(TodoReposistory todoReposistory) {
        this.todoReposistory = todoReposistory;
    }

    public List<Todo> getTodoListByStatus(Boolean status) {
        return this.todoReposistory.getTodoListByStatus(status);
    }

    public Todo getTodoById(Integer id) {
        var todo = todoReposistory.getTodoById(id);
        return todo.orElse(null);
    }

    public boolean createNewTodo(Todo newTodo) {
        var ret = this.todoReposistory.addTodo(newTodo);
        return ret != null;
    }

    public boolean updateTodo(Todo newTodo, Integer id) {
        var ret = this.todoReposistory.updateTodoById(newTodo,id);
        return ret.isPresent();
    }

    public boolean deleteTodo(Integer id) {
        return this.todoReposistory.deleteTodoById(id);
    }
}
