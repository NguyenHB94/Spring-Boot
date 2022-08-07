package com.example.springday05.controller;

import com.example.springday05.model.Todo;
import com.example.springday05.service.TodosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/todos")
public class TodosController {
    private final TodosService todosService;

    public TodosController(TodosService todosService) {
        this.todosService = todosService;
    }

    @RequestMapping("")
    public ResponseEntity<List<Todo>> getTodosByStatus(@RequestParam(value = "status", required = false) Boolean status) {
        var result = this.todosService.getTodosByStatus(status);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{todoId}")
    public ResponseEntity<Todo> getTodoListById(@PathVariable("todoId") Integer id) {
        var result = this.todosService.getTodoById(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping("")
    public ResponseEntity<Todo> createNewTodo(@RequestBody Todo newTodo) {
        var ret = this.todosService.createNewTodo(newTodo);
        return ResponseEntity.created(URI.create("/")).body(null);
    }

    @PatchMapping("/{todoId}")
    public ResponseEntity<Void> updateTodoById(
            @RequestBody Todo newTodo,
            @PathVariable("todoId") Integer id
    ) {
        var ret = this.todosService.updateTodo(newTodo, id);
        return ResponseEntity.ok().body(null);
    }

    @DeleteMapping("/{todoId}")
    public ResponseEntity<Void> deleteTodoById(@PathVariable("todoId") Integer id) {
        this.todosService.deleteTodo(id);
        return ResponseEntity.ok().body(null);
    }

}
