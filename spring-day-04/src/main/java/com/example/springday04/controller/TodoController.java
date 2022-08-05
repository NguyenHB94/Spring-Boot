package com.example.springday04.controller;

import com.example.springday04.model.Todo;
import com.example.springday04.reposistory.TodoReposistory;
import com.example.springday04.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("")
    public ResponseEntity<List<Todo>> getTodoListByStatus(@RequestParam(value = "status", required = false) Boolean status) {
        var result = this.todoService.getTodoListByStatus(status);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{todoId}")
    public ResponseEntity<Todo> getTodoListById(@PathVariable("todoId") Integer id) {
        var result = this.todoService.getTodoById(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping("")
    public ResponseEntity<Todo> createNewTodo(@RequestBody Todo newTodo) {
        var ret = this.todoService.createNewTodo(newTodo);
        if (ret) {
            return ResponseEntity.created(URI.create("/")).body(null);
        } else {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @PatchMapping("/{todoId}")
    public ResponseEntity<Void> updateTodoById(
            @RequestBody Todo newTodo,
            @PathVariable("todoId") Integer id
    ) {
        var ret = this.todoService.updateTodo(newTodo, id);
        if (ret) {
            return ResponseEntity.ok().body(null);
        } else {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @DeleteMapping("/{todoId}")
    public ResponseEntity<Void> deleteTodoById(@PathVariable("todoId") Integer id) {
        var ret = this.todoService.deleteTodo(id);
        if (ret) {
            return ResponseEntity.ok().body(null);
        } else {
            return ResponseEntity.internalServerError().body(null);
        }
    }
}
