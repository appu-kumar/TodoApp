package com.leapfinance.todo.dao;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leapfinance.todo.model.Task;

@Repository
public interface TaskRepo extends JpaRepository<Task,UUID> {

}
