package ru.vmakarenko.rest;

import ru.vmakarenko.entities.User;
import ru.vmakarenko.services.UserService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * Created by VMakarenko on 2/4/15.
 */
@Path(value = "auth")
public class AuthResource {
    @Inject
    UserService userService;

    @POST
    @Path("/register")
    public Response register(User user){
        if(!user.getPassword().equals(user.getPassword2())){
            // TODO
            return Response.status(Response.Status.BAD_REQUEST).build();
        }else{
            userService.createUser(user);
            return Response.ok().build();
        }
    }

    @POST
    @Path("/login")
    public Response login(User user){
        return Response.ok().build();
    }

    @POST
    @Path("/logout")
    public Response logout(){
        return Response.ok().build();
    }
}
