package com.abhishek.kulapkar.task.tracker.Repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.abhishek.kulapkar.task.tracker.entity.entity;

public interface Repository extends JpaRepository<entity, Integer>{

	List<entity> findByTaskName(String taskName);

	void deleteByTaskName(String DeleteTask);

}
