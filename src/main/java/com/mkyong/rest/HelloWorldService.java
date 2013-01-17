package com.mkyong.rest;
 
import java.net.URI;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
 
@Path("/hello")
public class HelloWorldService {
 
	@GET
	@Path("/x/{param}")
	public Response getMsg(@PathParam("param") String msg) {
 
		String output = "Jersey say : " + msg;
 
		return Response.status(200).entity(output).build();
 
	}
	
	@GET
	@Path("/redirect/{param}")
	public Response redirect(@PathParam("param") String status) {
		URI location = UriBuilder.fromUri("http://localhost:8080/RESTfulExample/redirect/" + status + ".html").build(); 
		return Response.temporaryRedirect(location).build();
	}

}