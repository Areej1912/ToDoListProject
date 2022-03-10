package com.qa.service;

import org.springframework.stereotype.Service;

import com.qa.Repo.ToDoRepo;
import com.qa.entity.ToDoItem;

@Service
public class ToDoService {


	private ToDoRepo repo;

	public ToDoItem createToDoItem(ToDoItem todoitem) {
	
		return this.repo.save(todoitem); 
	}


	public boolean deleteToDoItem(Long id) {
		// TODO Auto-generated method stub
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}
	
}
