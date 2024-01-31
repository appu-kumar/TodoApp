package com.leapfinance.todo.model;

import java.sql.Date;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Task {

	// Design a data model for tasks with fields: title, description, due_date,
	// completed.
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	
	private String title;
	private String description;
	private Date dueDate;
	private Boolean completed;

	// default constructor
	public Task() {
	}

	public Task(String title, String description, Date dueDate, Boolean completed) {
		this.title = title;
		this.description = description;
		this.dueDate = dueDate;
		this.completed = completed;
	}
	
	

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Boolean getCompleted() {
		return completed;
	}

	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}

}
