package com.qa.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.entity.ToDoItem;

public interface ToDoRepo extends JpaRepository<ToDoItem, Long> {

}
