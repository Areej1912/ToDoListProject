package com.qa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name= "ToDo") 
public class ToDoItem {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	@Column(name="name")
	private String name; 
	@Column(name="complete")
	private boolean complete;

	public ToDoItem() {}
	public ToDoItem(Long id, String name, boolean complete) {
		super();
		this.id = id;
		this.name = name;
		this.complete = complete;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isComplete() {
		return complete;
	}
	public void setComplete(boolean complete) {
		this.complete = complete;
	}
	@Override
	public String toString() {
		return "ToDoItem [id=" + id + ", name=" + name + ", complete=" + complete + "]";

	}
} 
