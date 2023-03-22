package me.jhc.project_todo2.controller.utils;

import me.jhc.project_todo2.controller.dto.CreateTodoRequest;
import me.jhc.project_todo2.store.entitis.Todo;

public class EntityDtoUtils {
    public static Todo toEntity(CreateTodoRequest createTodoRequest) {
        Todo todo = new Todo();
        todo.setItem(createTodoRequest.getItem());
        todo.setStatus(createTodoRequest.getStatus());
        todo.setUser_id(createTodoRequest.getUser_id());
        return todo;
    }
}
