package com.leapfinance.todo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leapfinance.todo.dao.TaskRepo;
import com.leapfinance.todo.model.Task;


@Service
public class TodoServiceImp implements TodoService {

	
	@Autowired
	private TaskRepo taskRepo;
	
	@Override
	public void add(Task task) {
		taskRepo.save(task);
		
	}

	@Override
	public Optional<Task> findById(int taskId) {
		return taskRepo.findById(taskId);
	}

	@Override
	public void update(Task task) {
		taskRepo.save(task);
	}

	@Override
	public void delete(int taskId) {
		taskRepo.deleteById(taskId);
	}

	@Override
	public List<Task> getAllTask() {
		
		return taskRepo.findAll();
	}

}
