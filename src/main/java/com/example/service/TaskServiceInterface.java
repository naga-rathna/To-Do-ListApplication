package com.example.service;

import java.util.List;

import com.example.entity.Task;
import com.example.entity.User;

public interface TaskServiceInterface {
	Task saveTask(Task task);
    List<Task> getTasksByUser(User user);
    Task getTaskById(Long id);
    void deleteTask(Long id);
}
