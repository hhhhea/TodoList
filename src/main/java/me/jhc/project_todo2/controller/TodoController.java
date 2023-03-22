package me.jhc.project_todo2.controller;

import lombok.RequiredArgsConstructor;
import me.jhc.project_todo2.controller.dto.CreateTodoRequest;
import me.jhc.project_todo2.controller.dto.ErrorResponse;
import me.jhc.project_todo2.controller.dto.UpdateTodoRequest;
import me.jhc.project_todo2.controller.utils.EntityDtoUtils;
import me.jhc.project_todo2.service.TodoService;
import me.jhc.project_todo2.store.entitis.Todo;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("todos")
public class TodoController {
    public final TodoService todoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Todo create(@RequestBody CreateTodoRequest createtodorequest) {
        return todoService.create(EntityDtoUtils.toEntity(createtodorequest));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Todo update(@PathVariable Long id,@RequestBody UpdateTodoRequest updateTodoRequest) {
        return todoService.update(id,updateTodoRequest);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        todoService.delete(id);
    }

    @GetMapping("{status}")
    public List<Todo> getCompleteTodo(@PathVariable String status) {
        return todoService.getAllCompletes(status);
    }
    @GetMapping
    public List<Todo> getAll() {
        return todoService.getAllTodos();
    }

    @ExceptionHandler({DataIntegrityViolationException.class})
    public ErrorResponse handle(DataIntegrityViolationException e) {
        return new ErrorResponse("user_id is exist",e.getMessage());
    }
}
