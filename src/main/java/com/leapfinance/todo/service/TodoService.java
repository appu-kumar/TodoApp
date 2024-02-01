package com.leapfinance.todo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


import com.leapfinance.todo.model.Task;


public interface TodoService {

	void add(Task task);
    Optional<Task> findById(UUID taskId);
    List<Task> getAllTask();
    void update(Task task);
    void delete(UUID taskId);
}
