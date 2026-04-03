/**
 * 
 */
package com.abhishek.kulapkar.task.tracker.TaskDataTransferObject;

import java.util.Date;

import com.abhishek.kulapkar.task.tracker.Enum.taskstatus;

/**
 * 
 */
public class TaskDataTransferObject {

	private String taskName;
	private String taskDescription;
	private taskstatus taskStatus;
	private Date createdAt;
	private Date updatedAt;
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getTaskDescription() {
		return taskDescription;
	}
	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}
	public taskstatus getTaskStatus() {
		return taskStatus;
	}
	public void setTaskStatus(taskstatus taskStatus) {
		this.taskStatus = taskStatus;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
	
	
}
