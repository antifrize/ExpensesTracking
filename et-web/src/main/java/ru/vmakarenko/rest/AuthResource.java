package ru.vmakarenko.rest;

import ru.vmakarenko.entities.User;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * Created by VMakarenko on 2/4/15.
 */
@Path(value = "auth")
public class AuthResource {
    /*public Response authorize(String login, char[] pwd){
        return Response.ok().build();
    }
    public Response register(User user){
        return Response.ok().build();
    }*/
    @GET
    public String test(){
        return "Hello";
    }
}
