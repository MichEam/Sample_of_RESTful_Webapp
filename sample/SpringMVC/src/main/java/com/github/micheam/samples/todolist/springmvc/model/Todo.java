package com.github.micheam.samples.todolist.springmvc.model;

public class Todo {

	private final String id;
	private String description;

	public Todo(String id, String description) {
		super();
		this.id = id;
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String aDescription) {
		this.description = aDescription;
	}
}
