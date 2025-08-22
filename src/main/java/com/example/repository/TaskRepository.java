package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Task;
import com.example.entity.User;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
	List<Task> findByUser(User user);
}
