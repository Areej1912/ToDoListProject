package com.qa.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.qa.service.ToDoService;
import com.qa.entity.ToDoItem;



@RestController 
public class ToDoListcontroller {

	private ToDoService service; {
		this.service= service; 
		
	}
	
	@PostMapping("/create")
	public ResponseEntity<ToDoItem>createToDoItem(@RequestBody ToDoItem todoitem) {
		return new ResponseEntity<ToDoItem>(this.service.createToDoItem (todoitem), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean>deleteToDoItem(@PathVariable Long id) {
		boolean deleted = this.service.deleteToDoItem(id);
		if(deleted) {
			return new ResponseEntity<Boolean>(deleted, HttpStatus.ACCEPTED);
			} else {
				return new ResponseEntity<Boolean>(deleted, HttpStatus.NOT_IMPLEMENTED);
			
			}
		
	} 
	
}