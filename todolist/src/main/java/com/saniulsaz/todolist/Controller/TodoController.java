package com.saniulsaz.todolist.Controller;

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

import com.saniulsaz.todolist.Model.Todo;
import com.saniulsaz.todolist.Repository.TodoRepository;
@RestController
@RequestMapping("/api/todos")
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    // Create a new ToDo
    @PostMapping
    public Todo createTodo(@RequestBody Todo todo) {
        return todoRepository.save(todo);
    }

    // Get all ToDos
    @GetMapping
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    // Get ToDo by ID
    @GetMapping("/{id}")
    public Todo getTodoById(@PathVariable String id) {
        return todoRepository.findById(id).orElse(null);
    }

    // Update a ToDo
    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable String id, @RequestBody Todo updatedTodo) {
        return todoRepository.findById(id).map(todo -> {
            todo.setTitle(updatedTodo.getTitle());
            todo.setCompleted(updatedTodo.isCompleted());
            return todoRepository.save(todo);
        }).orElse(null);
    }

    // Delete a ToDo
    @DeleteMapping("/{id}")
    public String deleteTodo(@PathVariable String id) {
        todoRepository.deleteById(id);
        return "Task with ID " + id + " deleted successfully!";
    }
}
