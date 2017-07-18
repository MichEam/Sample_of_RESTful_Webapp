package com.github.micheam.samples.todolist.springmvc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.micheam.samples.todolist.springmvc.model.Todo;

@RestController
public class TodoController {

	@RequestMapping(value = "/todo", method=RequestMethod.GET)
	public Todo list(@RequestParam(value = "id", required = true) String id) {

		return new Todo(id, "test");
	}
}
