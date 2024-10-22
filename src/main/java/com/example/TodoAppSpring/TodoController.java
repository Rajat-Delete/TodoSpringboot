package com.example.TodoAppSpring;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    public List<Todo> getTodos(){
        return todos;
    }


    @PostMapping("/todos")
    public Todo createTodo(@RequestBody Todo todo){
        todos.add(todo);
        return todo;
    }

}
