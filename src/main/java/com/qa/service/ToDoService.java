package com.qa.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
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


	
	public List<ToDoItem> getALLToDoItems() {
		return this.repo.findAll();
	}


	public ToDoItem getToDoItemById(Long id) {
		Optional<ToDoItem> todoitemget = this.repo.findById(id);
		if (todoitemget.isPresent()) {
			return todoitemget.get();	
		} else {
			throw new EntityNotFoundException("To do item not found using this Id!");
		}
		
				
	}

	public ToDoItem updateToDoItem(Long id, ToDoItem todoitem) {
		ToDoItem foundToDoItem = this.getToDoItemById(id);
		foundToDoItem.setName(todoitem.getName());
		foundToDoItem.setComplete(todoitem.isComplete());
		
		return this.repo.save(foundToDoItem);
	}
	
}
