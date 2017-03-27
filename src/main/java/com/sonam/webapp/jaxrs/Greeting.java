package com.sonam.webapp.jaxrs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Service;

@Path("/sayHello")
public interface Greeting {

    @GET
    @Path("/{a}")
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello(@PathParam("a") String a);

}