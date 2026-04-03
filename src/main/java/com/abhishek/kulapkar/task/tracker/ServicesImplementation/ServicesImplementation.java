package com.abhishek.kulapkar.task.tracker.ServicesImplementation;

import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhishek.kulapkar.task.tracker.Enum.taskstatus;
import com.abhishek.kulapkar.task.tracker.Repository.Repository;
import com.abhishek.kulapkar.task.tracker.TaskDataTransferObject.TaskDataTransferObject;
import com.abhishek.kulapkar.task.tracker.entity.entity;
import com.abhishek.kulapkar.task.tracker.services.Services;

@Service
public class ServicesImplementation implements Services{

	@Autowired
	Repository Repo;
	
	@Override
	public entity AddTask(TaskDataTransferObject Tdto) {
		// TODO Auto-generated method stub
		
		String TaskName = Tdto.getTaskName();
		String TaskDescription = Tdto.getTaskDescription();
		
		
		
		if (TaskName==null || TaskName.isEmpty()) {
			throw new IllegalArgumentException("Task Name should not be empty!");
		}
		
		if (TaskDescription==null || TaskDescription.isEmpty()) {
			throw new IllegalArgumentException("Task Description should not be empty!");
		}
		
		entity AddedTasks = new entity();
		
		AddedTasks.setTaskName(TaskName);
		AddedTasks.setTaskDescription(TaskDescription);
		AddedTasks.setTaskStatus(taskstatus.todo);
		AddedTasks.setCreatedAt(new Date());
		entity SaveAddedTasks = Repo.save(AddedTasks);
		
		
		return SaveAddedTasks;
		
	}

	@Override
	public String UpdateTask(String taskName, TaskDataTransferObject Tdto) {
		// TODO Auto-generated method stub
		
		if(taskName == null) {
			throw new IllegalArgumentException("Task Name is Mandatory while Updating Product!");
		}
		
		List<entity> gettingUpdateTask = Repo.findByTaskName(taskName);
		
		if (gettingUpdateTask.size() == 0) {
			throw new IllegalArgumentException("Cannot update: No tasks found with the name '" + taskName + "'");
		}
		
		int updateCount = 0;
		for(int i=0; i<gettingUpdateTask.size(); i++) {
			entity UpdatedTask = gettingUpdateTask.get(i);
			
			if (Tdto.getTaskName() == null || Tdto.getTaskName().isEmpty()) {
				throw new IllegalArgumentException("Task Name cannot be null or Empty");
			}else {
				UpdatedTask.setTaskName(Tdto.getTaskName());
			}
			
			if(Tdto.getTaskDescription() == null || Tdto.getTaskDescription().isEmpty()) {
				throw new IllegalArgumentException("Task Description cannot be null or Empty");
			}else {
				UpdatedTask.setTaskDescription(Tdto.getTaskDescription());
			}
			
			if(Tdto.getTaskStatus() != null) {
				UpdatedTask.setTaskStatus(Tdto.getTaskStatus());
			}else {
				throw new IllegalArgumentException("Task Status cannot be null");
			}
			
			UpdatedTask.setUpdatedAt(new Date());
			
			Repo.save(UpdatedTask);
			updateCount++;
						
		}
	      
		if (updateCount == 0) {
	         return "Failed: Could not find any task matching '" + taskName + "'. Check database for exact spelling!";
	    }
		
		return "Successfully updated " + updateCount + " task(s) previously named: " + taskName;
	}

	@Override
	public String DeleteTask(String taskName) {
		// TODO Auto-generated method stub
		
		if(taskName == null) {
			throw new IllegalArgumentException("Task Name is Invalid!");
		}
		
		List<entity> foundTasksForDeletion = Repo.findByTaskName(taskName);
		
		if(foundTasksForDeletion.size()==0) {
			throw new IllegalArgumentException("Cannot delete: No tasks found with the name '" + taskName + "'");
		}
		
		int deleteCount=0;
		for (int i = 0; i < foundTasksForDeletion.size(); i++) {
	        entity taskToDelete = foundTasksForDeletion.get(i);
	        Repo.delete(taskToDelete);
	        deleteCount++;
	    }
		
		return "Successfully deleted " + deleteCount + " task(s) named: " + taskName;
       
	}

	@Override
	public List<entity> GetAllTasks() {
		// TODO Auto-generated method stub
	   List<entity> getTasks = Repo.findAll();
		
		return getTasks;
	}

	@Override
	public List<entity> GetToDoTasks() {
		// TODO Auto-generated method stub
		List<entity> allTasks = Repo.findAll();
		
		
		List<entity> todoTasks = new ArrayList<>();
		
		for (int i=0; i<allTasks.size();i++) {
			entity currentTasks = allTasks.get(i);
			
			if(currentTasks.getTaskStatus() !=null && currentTasks.getTaskStatus() == taskstatus.todo) {
				
				todoTasks.add(currentTasks);
			}
			
		}
		return todoTasks;
	}

	@Override
	public List<entity> GetInProgressTasks() {
		// TODO Auto-generated method stub
		
		List<entity> allTasks = Repo.findAll();
		
		List<entity> getInProgresstasks = new ArrayList<>();
		
		for(int i=0;i<allTasks.size();i++) {
			entity currentTasks = allTasks.get(i);
			if (currentTasks.getTaskStatus() !=null && currentTasks.getTaskStatus() == taskstatus.inprogress) {
				
				getInProgresstasks.add(currentTasks);
			}
		}
		return getInProgresstasks;
	}

	@Override
	public List<entity> GetDoneTasks() {
		// TODO Auto-generated method stub
		List<entity> allTasks = Repo.findAll();
		
		List<entity> getDoneTasks = new ArrayList<>();
		
		for (int i=0; i<allTasks.size();i++) {
			entity currentTasks = allTasks.get(i);
			
			if(currentTasks.getTaskStatus() != null && currentTasks.getTaskStatus() == taskstatus.done) {
				getDoneTasks.add(currentTasks);
			}
		}
		return getDoneTasks;
	}

	

}
