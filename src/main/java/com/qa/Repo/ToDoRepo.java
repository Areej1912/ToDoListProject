package com.qa.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.entity.ToDoItem;

public interface ToDoRepo extends JpaRepository<ToDoItem, Long> {

	List<ToDoItem> findByName(String name);
	List<ToDoItem>findByPublished(boolean published);
	
}
