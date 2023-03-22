package me.jhc.project_todo2.service;

import lombok.RequiredArgsConstructor;
import me.jhc.project_todo2.controller.dto.UpdateTodoRequest;
import me.jhc.project_todo2.store.entitis.Todo;
import me.jhc.project_todo2.store.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;


    public Todo create(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo update(Long id, UpdateTodoRequest updateTodoRequest) {
        Optional<Todo> completeTodo = todoRepository.findById(id);
        return completeTodo
                .map(com -> {com.setStatus(updateTodoRequest.getStatus());
                return todoRepository.save(com);
                }).orElseThrow(()->new RuntimeException("Todo not found"));
    }

    public void delete(Long id) {
        todoRepository.deleteById(id);
    }


    public List<Todo> getAllCompletes(String status) {
        return todoRepository.findAllByStatus(status);
    }

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }
}
