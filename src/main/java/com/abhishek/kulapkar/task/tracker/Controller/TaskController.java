package com.abhishek.kulapkar.task.tracker.Controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhishek.kulapkar.task.tracker.TaskDataTransferObject.TaskDataTransferObject;
import com.abhishek.kulapkar.task.tracker.entity.entity;
import com.abhishek.kulapkar.task.tracker.services.Services;

@RestController
@RequestMapping("/TaskTracker")
public class TaskController {
	
	@Autowired
	private Services ControllerServices;
	
     
	@PostMapping("/AddTask")
	public entity AddTask(@RequestBody TaskDataTransferObject Tdto) {
		
		entity AddTaskMap = ControllerServices.AddTask(Tdto);
		return AddTaskMap;
	}
	
	@PutMapping("/UpdateTask/{taskName}")
	public String UpdateTask(@PathVariable  String taskName,@RequestBody TaskDataTransferObject Tdto) {
		
		String UpdateTaskMap = ControllerServices.UpdateTask(taskName, Tdto);
		
		return UpdateTaskMap;
	}
	
	@DeleteMapping("/DeleteTask/{taskName}")
	public String DeleteTask(@PathVariable String taskName) {
		
		String DeleteTaskMap = ControllerServices.DeleteTask(taskName);
		return DeleteTaskMap;
	}
	
	@GetMapping("/ViewTasks/viewAllTasks")
	public List<entity> GetAllTasks() {
		List<entity> viewAllTasks = ControllerServices.GetAllTasks();
		return viewAllTasks;
	}
	
	@GetMapping("/ViewTasks/viewToDoStatustasks")
	public List<entity>GetToDoTasks(){
		List<entity> getToDoTasks = ControllerServices.GetToDoTasks();
		return getToDoTasks;
	}
	
	@GetMapping("/viewTasks/viewInProgresstasks") 
	public List<entity>GetInProgressTasks(){
		List<entity> getInProgressTasks = ControllerServices.GetInProgressTasks();
		
		return getInProgressTasks;
	}
	
	@GetMapping("/viewTasks/viewDoneTasks")
	public List<entity>GetDoneTasks(){
		List<entity> getDoneTasks = ControllerServices.GetDoneTasks();
		return getDoneTasks;
	}
	
	
	
		
		
}
	


