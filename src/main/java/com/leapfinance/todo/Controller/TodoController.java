package com.leapfinance.todo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.leapfinance.todo.model.Task;
import com.leapfinance.todo.service.TodoService;

@CrossOrigin("*")
@RestController
public class TodoController {
	
	
	@Autowired
	private TodoService todoService;
	
	
	@PostMapping("/add")
	public ResponseEntity<Object> addTask(@RequestBody Task task)             // @RequestBody annotation is used for deserialization  means json/xml to java
	{
		
		try {
			todoService.add(task); // Task info added
			return new ResponseEntity<>("Task is added successfully", HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
			

		}
	}
	
	@GetMapping("/tasks")
	public List<Task> getAllTask()
	{
	        return todoService.getAllTask();
	}
	
	@GetMapping("/task/{taskId}")
	public Object getTaskDetail(@PathVariable("taskId") int taskId) {
		
		try
		{
		Optional<Task> obj=todoService.findById(taskId);
		if(obj.isPresent())
			 return obj.get();
		else
			return new ResponseEntity<>("Task with this id is not present", HttpStatus.BAD_REQUEST);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
	}
	
	
	@PutMapping("/task/{taskId}")
	public ResponseEntity<Object> updateLoadingDetail(@PathVariable("taskId") int taskId, @RequestBody Task task) {
		try {
			Optional<Task> opt = todoService.findById(taskId);
			if (opt.isPresent()) {
			     Task taskObj = opt.get();
				taskObj.setTitle(task.getTitle());
				taskObj.setDescription(task.getDescription());
				taskObj.setDueDate(task.getDueDate());
				taskObj.setCompleted(task.getCompleted());
				todoService.update(taskObj);
				return new ResponseEntity<>("task is updated successfully", HttpStatus.OK);

			} else {
				return new ResponseEntity<>("task not found", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		

	}
	
	@DeleteMapping("/task/{taskId}")
	public ResponseEntity<Object> deleteLoadingDetail(@PathVariable("taskId") int taskId) {
		
		try {
			Optional<Task> task= todoService.findById(taskId);
			if (task.isPresent()) {
				todoService.delete(taskId);
				return new ResponseEntity<>("task is Deleted successfully", HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Task not found", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	

}
