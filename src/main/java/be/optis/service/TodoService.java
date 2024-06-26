package be.optis.service;

import be.optis.entity.TodoItem;
import be.optis.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService implements CommandLineRunner {

    @Autowired
    private TodoRepository todoRepository;

    public List<TodoItem> getAllTodoItems() {
        return todoRepository.findAll();
    }

    public List<TodoItem> getAllTodoItemsByContext(String context) {
        return todoRepository.findByContextTag(context);
    }

    public TodoItem updateTodoItem(Long todoId, TodoItem todoItem) {
        return todoRepository.findById(todoId)
            .map(todo -> {
                todo.setCompleted(todoItem.isCompleted());
                todo.setDescription(todoItem.getDescription());
                todo.setPriority(todoItem.getPriority());
                todo.setContextTag(todoItem.getContextTag());
                todo.setCreationDate(todoItem.getCreationDate());
                todo.setCompletionDate(todoItem.getCompletionDate());
                todo.setProjectTag(todoItem.getProjectTag());
                return todoRepository.save(todo);
            })
            .orElseThrow(() -> new RuntimeException("Todo not found with id " + todoId));
    }

    private static List<TodoItem> extractTodoItems() {
        List<TodoItem> todoItems = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/todo.csv"));
            String line;

            // skip first row (heading names)
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                // sort lines on priority, empty values
                todoItems.add(getTodoItem(line));
            }
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }

        return todoItems;
    }

    private static TodoItem getTodoItem(String line) {
        String[] columns = line.split(",");

        boolean completed = Boolean.parseBoolean(columns[0]);
        String priority = columns[1];
        String completionDate = columns[2];
        String creationDate = columns[3];
        String description = columns[4];
        String projectTag = "";
        String contextTag = "";
        if (columns.length > 5) {
            projectTag = columns[5];
        }
        if (columns.length > 6) {
            contextTag = columns[6];
        }

        return new TodoItem(completed, priority, completionDate, creationDate, description, projectTag, contextTag);
    }

    @Override
    public void run(String... args) {
        List<TodoItem> list = extractTodoItems();
        todoRepository.saveAll(list);
    }
}
