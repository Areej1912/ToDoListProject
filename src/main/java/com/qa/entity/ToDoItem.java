package com.qa.entity;
 
public class ToDoItem {

	private Long id;
	private String name; 
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
