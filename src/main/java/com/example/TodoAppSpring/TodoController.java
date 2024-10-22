package com.example.TodoAppSpring;


import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TodoController {

    public static List<Todo> todos;

    public TodoController(){
        todos = new ArrayList<>();
        todos.add(new Todo(1, false, "Todo 1", 1));
        todos.add(new Todo(2, true, "Todo 2", 2));

    }


    @GetMapping("/todos")
    public ResponseEntity<List<Todo>> getTodos(){
        return ResponseEntity.status(HttpStatus.OK).body(todos);
    }


    @PostMapping("/todos")

    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo){
        /*
        We can either use this annotation to set the response code @ResponseStatus(HttpStatus.CREATED) or use ResponseEntity class
         */
        todos.add(todo);
        return ResponseEntity.status(HttpStatus.CREATED).body(todo);
    }

}
