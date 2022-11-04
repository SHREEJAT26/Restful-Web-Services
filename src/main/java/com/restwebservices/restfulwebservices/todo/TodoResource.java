package com.restwebservices.restfulwebservices.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class TodoResource
{
    @Autowired
    private TodoHardcodedService todoHardcodedService;

    //--/users/{username}/todos
    @GetMapping("/users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable String username)
    {
        return todoHardcodedService.retriveAllTodos();
    }

    //--/users/{username}/todos
    @GetMapping("/users/{username}/todos/{id}")
    public Todo getTodos(@PathVariable String username,@PathVariable long id)
    {
        return todoHardcodedService.findById(id);
    }


    //--/users/{username}/todos/{id}
    ///users/Shreeja/todos/1
    @DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id)
    {
        Todo todo = todoHardcodedService.deleteById(id);
        if(todo!=null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }


    //Edit Update an existing Todo
    //PUT /users/{username}/todos/{id}

    @PutMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable long id,@RequestBody Todo todo)
    {
        Todo todoUpdated = todoHardcodedService.save(todo);
        return new ResponseEntity<Todo>(todo, HttpStatus.OK);
    }


    //Create a new Todo
    //POST /users/{username}/todos/

    @PutMapping("/users/{username}/todos")
    public ResponseEntity<Void> updateTodo(@PathVariable String username,@RequestBody Todo todo)
    {
        Todo createTodo = todoHardcodedService.save(todo);
        //We need to return location of current resource
        //Get current resource url
        ///{id}

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(createTodo.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }





}
