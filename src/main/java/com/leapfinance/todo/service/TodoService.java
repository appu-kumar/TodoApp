package com.leapfinance.todo.service;

import java.util.Optional;
import java.util.UUID;


import com.leapfinance.todo.model.Task;


public interface TodoService {

	void add(Task task);
    Optional<Task> findById(UUID taskId);
    void update(Task task);
    void delete(UUID taskId);
}
