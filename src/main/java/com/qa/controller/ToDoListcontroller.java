package com.qa.controller;

<<<<<<< Updated upstream
=======
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
>>>>>>> Stashed changes
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class ToDoListcontroller {

<<<<<<< Updated upstream
	
=======
	private ToDoService service;
	@Autowired
	 public ToDoListcontroller(ToDoService service) {
		
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
	
	
	@PutMapping("/Update/{id}")
	public ResponseEntity<ToDoItem> updateToDoItem(@PathVariable Long id, @RequestBody ToDoItem todoitem){
		return new ResponseEntity<ToDoItem>(this.service.updateToDoItem(id, todoitem), HttpStatus.ACCEPTED);
		
	}

	@GetMapping("/getALL")
	public ResponseEntity<List<ToDoItem>> getALLToDoItems(){
		return new ResponseEntity<List<ToDoItem>>(this.service.getALLToDoItems(),HttpStatus.OK);
		
		
	}

	@GetMapping("/getbyId/{id}")
	public ResponseEntity<ToDoItem> getToDoItemById(@PathVariable Long id) {
		return new ResponseEntity<ToDoItem>(this.service.getToDoItemById(id), HttpStatus.OK);
	}
	
	
>>>>>>> Stashed changes
	
}
