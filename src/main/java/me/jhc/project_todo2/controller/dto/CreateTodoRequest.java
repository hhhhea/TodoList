package me.jhc.project_todo2.controller.dto;

import lombok.Data;

@Data
public class CreateTodoRequest {
    private String item;
    private String status;
    private Long user_id;
}
