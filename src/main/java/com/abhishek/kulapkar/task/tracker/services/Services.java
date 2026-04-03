package com.abhishek.kulapkar.task.tracker.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.abhishek.kulapkar.task.tracker.TaskDataTransferObject.TaskDataTransferObject;
import com.abhishek.kulapkar.task.tracker.entity.entity;

@Service
public interface Services {
	entity AddTask(TaskDataTransferObject Tdto);
	String UpdateTask(String taskName, TaskDataTransferObject Tdto);
	String DeleteTask(String taskName);
	List<entity> GetAllTasks();
	List<entity> GetToDoTasks();
	List<entity> GetInProgressTasks();
	List<entity> GetDoneTasks();
}
