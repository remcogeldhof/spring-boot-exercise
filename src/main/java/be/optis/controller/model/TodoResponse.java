package be.optis.controller.model;

import be.optis.entity.TodoItem;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class TodoResponse {
    private int count;
    private List<TodoItem> items;
}
