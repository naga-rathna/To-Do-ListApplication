package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Task;
import com.example.entity.User;
import com.example.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskServiceInterface {
	 @Autowired
	    private TaskRepository taskRepository;

	    @Override
	    public Task saveTask(Task task) {
	        return taskRepository.save(task);
	    }

	    @Override
	    public List<Task> getTasksByUser(User user) {
	        return taskRepository.findByUser(user);
	    }

	    @Override
	    public Task getTaskById(Long id) {
	        return taskRepository.findById(id).orElse(null);
	    }

	    @Override
	    public void deleteTask(Long id) {
	        taskRepository.deleteById(id);
	    }
}
