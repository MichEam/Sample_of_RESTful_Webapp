package com.github.micheam.samples.todolist.jersey.jetty;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/todo")
public class EntryPoint {

	@GET
	@Path("list")
    @Produces(MediaType.TEXT_PLAIN)
	public String test() {
		return "test";
	}
}
