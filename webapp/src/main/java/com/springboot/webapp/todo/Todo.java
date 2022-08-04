package com.springboot.webapp.todo;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Todo {
    private int id;
    private String username;
    private String description;
    private LocalDate targetDat;
    private boolean done;

    public Todo(int id, String username, String description, LocalDate targetDat, boolean done)
    {
        this.id = id;
        this.username = username;
        this.description = description;
        this.targetDat = targetDat;
        this.done = done;
    }
}
