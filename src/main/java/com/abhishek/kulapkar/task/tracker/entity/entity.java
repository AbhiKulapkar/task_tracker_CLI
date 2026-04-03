/**
 * 
 */
package com.abhishek.kulapkar.task.tracker.entity;

import java.util.Date;

import com.abhishek.kulapkar.task.tracker.Enum.taskstatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


/**
 * 
 */

@Table(name = "task_tracker")
@Entity
public class entity {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer taskId;
	
	@Column(name = "task_name")
	private String taskName;
	
	@Column(name = "task_description")
	private String taskDescription;
	
	@Column(name = "task_status")
	@Enumerated(EnumType.STRING)
	private taskstatus taskStatus;
	
	@Column(name = "created_at")
	private Date createdAt;
	
	@Column(name = "updated_at")
	private Date updatedAt;
	
	

	/**
	 * 
	 */
	public entity() {
		super();
		// TODO Auto-generated constructor stub
	}



	/**
	 * @param taskId
	 * @param taskName
	 * @param taskDescription
	 * @param taskStatus
	 * @param createdAt
	 * @param updatedAt
	 */
	public entity(Integer taskId, String taskName, String taskDescription, taskstatus taskStatus, Date createdAt,
			Date updatedAt) {
		super();
		this.taskId = taskId;
		this.taskName = taskName;
		this.taskDescription = taskDescription;
		this.taskStatus = taskStatus;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}



	public Integer getTaskId() {
		return taskId;
	}



	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}



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

	/**
	 * @param taskId
	 * @param taskName
	 * @param taskDescription
	 * @param taskStatus
	 * @param createdAt
	 * @param updatedAt
	 */
	
	
}
