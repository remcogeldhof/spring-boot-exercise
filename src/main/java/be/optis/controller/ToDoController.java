package be.optis.controller;

import be.optis.controller.model.TodoResponse;
import be.optis.entity.TodoItem;
import be.optis.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ToDoController {

    private final TodoService todoService;

    public ToDoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/")
    public String index() {
        return "Hello, world!";
    }

    @GetMapping("/todos")
    public ResponseEntity<TodoResponse> getTodoItems() {
        List<TodoItem> todoItems = todoService.getAllTodoItems();
        if (todoItems.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        TodoResponse todoResponse = new TodoResponse(todoItems.size(), todoItems);
        return new ResponseEntity<>(todoResponse, HttpStatus.OK);
    }

    @GetMapping("/todos/context")
    public ResponseEntity<TodoResponse> getTodoItems(@RequestParam(name = "context", required = false) String context) {
        List<TodoItem> todoItems = todoService.getAllTodoItemsByContext(context);
        if (todoItems.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        TodoResponse todoResponse = new TodoResponse(todoItems.size(), todoItems);
        return new ResponseEntity<>(todoResponse, HttpStatus.OK);
    }

    @PutMapping("/todos/{id}")
    public ResponseEntity<?> updateTodoItem(@PathVariable("id") Long id, @RequestBody TodoItem todoItem) {
        TodoItem updatedTodoItem = todoService.updateTodoItem(id, todoItem);
        return new ResponseEntity<>(updatedTodoItem, HttpStatus.OK);
    }

}
