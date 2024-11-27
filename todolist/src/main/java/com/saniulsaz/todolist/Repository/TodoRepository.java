package com.saniulsaz.todolist.Repository;

import com.saniulsaz.todolist.Model.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;

// Repository interface for ToDo CRUD operations
public interface TodoRepository extends MongoRepository<Todo, String> {
    // You can add custom queries here if needed
}