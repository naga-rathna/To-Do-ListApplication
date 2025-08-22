package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.entity.Task;
import com.example.entity.User;
import com.example.repository.TaskRepository;
import com.example.repository.UserRepository;
import com.example.service.TaskServiceInterface;

import jakarta.servlet.http.HttpSession;

@Controller
public class TaskController {
	@Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private TaskServiceInterface taskService;

    // Show form to create new task
    @GetMapping("/showNewTaskForm")
    public String showNewTaskForm(Model model) {
        model.addAttribute("task", new Task());
        return "add-task";
    }

    // Save the task submitted by the user
    @PostMapping("/saveTask")
    public String saveTask(@ModelAttribute("task") Task task, HttpSession session) {
        User user = (User) session.getAttribute("loggedInUser");
        if (user != null) {
            task.setUser(user); // associate task with current user
            taskRepository.save(task);
        }
        return "redirect:/tasks";
    }

    // View all tasks of the logged-in user
    @GetMapping("/tasks")
    public String viewTasks(Model model, HttpSession session) {
        User user = (User) session.getAttribute("loggedInUser");
        if (user != null) {
            List<Task> tasks = taskRepository.findByUser(user);
            model.addAttribute("tasks", tasks);
        }
        return "index"; // this will be the task list page
    }
    
 // Show form to update task
    @GetMapping("/updateTaskForm/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Task task = taskService.getTaskById(id);
        model.addAttribute("task", task);
        return "update-task";
    }

    // Handle task update (reuse /saveTask for simplicity)
    @PostMapping("/updateTask")
    public String updateTask(@ModelAttribute("task") Task task, HttpSession session) {
        User user = (User) session.getAttribute("loggedInUser");
        task.setUser(user); // Re-assign user to ensure ownership
        taskService.saveTask(task); // Save updated task
        return "redirect:/tasks";
    }

    // Delete task
    @GetMapping("/deleteTask/{id}")
    public String deleteTask(@PathVariable("id") Long id) {
        taskService.deleteTask(id);
        return "redirect:/tasks";
    }

}
