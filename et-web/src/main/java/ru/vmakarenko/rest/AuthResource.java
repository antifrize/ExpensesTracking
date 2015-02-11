package ru.vmakarenko.rest;

import ru.vmakarenko.common.AppConsts;
import ru.vmakarenko.entities.User;
import ru.vmakarenko.services.AuthService;
import ru.vmakarenko.services.UserService;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by VMakarenko on 2/4/15.
 */
@Path(value = "auth")
public class AuthResource {
    @Inject
    UserService userService;
    @Inject
    AuthService authService;

    @POST
    @Path("/register")
    public Response register(User user){
        if(!user.getPassword().equals(user.getPassword2())){
            // TODO WTF
            return Response.status(Response.Status.BAD_REQUEST).build();
        }else{
            userService.createUser(user);
            return Response.ok().build();
        }
    }

    @POST
    @Path("/login")
    public Response login(String login, @Context HttpServletRequest request){
        String[] list = login.split(":");
        User user = authService.login(list[0], list[1].toCharArray());
        if(user != null){
            request.getSession().setAttribute(AppConsts.CURRENT_USER_ATTRIBUTE, user);
            return Response.ok().build();
        }else{
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }

    @POST
    @Path("/logout")
    public Response logout(@Context HttpServletRequest request){
        request.getSession().removeAttribute("currentUser");
        return Response.ok().build();
    }

    @GET
    @Path("/getCurrentUser")
    public User getCurrentUser(@Context HttpServletRequest request){
        User user = (User)request.getSession().getAttribute("currentUser");
        user.setPassword(null);
        user.setPassword2(null);
        return user;
    }
}
