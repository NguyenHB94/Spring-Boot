package com.example.springday04.reposistory;

import com.example.springday04.FakeDB;
import com.example.springday04.model.Todo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class TodoReposistory {


    public List<Todo> getTodoListByStatus(Boolean status) {
        if (status == null) {
            return FakeDB.todoList;
        } else {
            return FakeDB.todoList.stream().filter(f -> f.getStatus() == status).toList();
        }
    }

    public Optional<Todo> getTodoById(Integer id) {
        return FakeDB.todoList.stream()
                .filter(todo -> Objects.equals(todo.getId(),id))
                .findAny();
    }

    public Todo addTodo(Todo newTodo) {
        FakeDB.todoList.add(newTodo);
        return newTodo;
    }

    public Optional<Todo> updateTodoById(Todo newTodo, Integer id) {
        var currentTodo = this.getTodoById(id);
        if (currentTodo.isPresent()) {
            var updateTodo = currentTodo.get();
            updateTodo.setId(newTodo.getId());
            updateTodo.setTitle(newTodo.getTitle());
            updateTodo.setStatus(newTodo.getStatus());

            return Optional.of(updateTodo);
        } else {
            throw new RuntimeException("Todo not found");
        }
    }

    public boolean deleteTodoById(Integer id) {
        return FakeDB.todoList.removeIf(todo -> Objects.equals(todo.getId(), id));
    }


}
