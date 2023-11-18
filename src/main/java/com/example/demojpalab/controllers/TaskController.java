package com.example.demojpalab.controllers;

import com.example.demojpalab.exceptions.ValidationException;
import com.example.demojpalab.tasks.Task;
import com.example.demojpalab.tasks.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tasks")
public class TaskController {
    @Autowired
    private TaskRepository taskRepository;

    @GetMapping()
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @PostMapping()
    public Task createTask(@RequestBody Task task) {
        if (task.isValid()) {
            throw new ValidationException("Not valid");
        }
        return taskRepository.save(task);
    }

    @GetMapping("{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    @PutMapping("{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task updatedTask) {
        updatedTask.setId(id);
        return taskRepository.save(updatedTask);
    }

    @DeleteMapping("{id}")
    public void deleteTask(@PathVariable Long id) {
        taskRepository.deleteById(id);
    }
}