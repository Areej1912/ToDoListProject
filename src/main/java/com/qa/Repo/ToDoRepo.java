package com.qa.Repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.entity.ToDoItem;

@Repository

public interface ToDoRepo extends JpaRepository<ToDoItem, Long> {

	List<ToDoItem>findByName(String name);
	List<ToDoItem>findByComplete(boolean complete);
	
}
