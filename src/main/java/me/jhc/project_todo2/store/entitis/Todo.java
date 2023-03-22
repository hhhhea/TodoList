package me.jhc.project_todo2.store.entitis;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String item;
    @Column(unique = true)
    private Long user_id;
    private String status;
}
