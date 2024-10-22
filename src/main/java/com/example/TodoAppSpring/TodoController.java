package com.example.TodoAppSpring;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {

    public static List<Todo> todos;

    public TodoController(){
        todos = new ArrayList<>();
        todos.add(new Todo(1, false, "Todo 1", 1));
        todos.add(new Todo(2, true, "Todo 2", 2));

    }


    @GetMapping("")
    public ResponseEntity<List<Todo>> getTodos(){
        return ResponseEntity.status(HttpStatus.OK).body(todos);
    }


    @PostMapping("")
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo){
        /*
        We can either use this annotation to set the response code @ResponseStatus(HttpStatus.CREATED) or use ResponseEntity class
         */
        todos.add(todo);
        return ResponseEntity.status(HttpStatus.CREATED).body(todo);
    }


    @GetMapping("/{todoId}")
    public ResponseEntity<Todo> getTodoById(@PathVariable(value = "todoId") long todoId){
        for(Todo t : todos){
            if(t.getId() == todoId){
                return ResponseEntity.ok(t);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{todoId}")
    public ResponseEntity<Object> deleteTodoById(@PathVariable(value = "todoId") Long todoId){
        for(int i = 0;i<todos.size();i++){
            if(todos.get(i).getId() == todoId){
                todos.remove(i);
                return ResponseEntity.ok().build();
            }
        }
        Map<String,String> map = new HashMap<>();
        map.put("ErrorMessage", "The todoId was not found!!");
        //return ResponseEntity.notFound().build();
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
    }

    @PatchMapping("/{todoId}")
    public ResponseEntity<Todo> updateTodoById(@PathVariable(value = "todoId") Long todoId){
        //logic to update the todoid
        //Implementation pending
        return ResponseEntity.ok().build();
    }

}
