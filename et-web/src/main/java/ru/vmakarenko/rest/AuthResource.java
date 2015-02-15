package ru.vmakarenko.rest;

import ru.vmakarenko.common.AppConsts;
import ru.vmakarenko.common.LoginPassCheckResult;
import ru.vmakarenko.common.RestResult;
import ru.vmakarenko.entities.User;
import ru.vmakarenko.services.AuthService;
import ru.vmakarenko.services.UserService;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;

/**
 * Created by VMakarenko on 2/4/15.
 */
@Path(value = "auth/")
public class AuthResource {
    @Inject
    UserService userService;
    @Inject
    AuthService authService;

    @POST
    @Path("register")
    @Produces(MediaType.APPLICATION_JSON)
    public Response register(User user) {
        LoginPassCheckResult result  = userService.vaidateUser(user);
        if (result.getStatus().equals(AppConsts.RESPONSE_ERROR)) {
            return Response.ok(result).build();
        } else {
            userService.createUser(user);
            return Response.ok().build();
        }
    }

    @POST
    @Path("login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(LoginDto loginDto, @Context HttpServletRequest request) {
        User user = authService.login(loginDto.getUsername(), loginDto.getPassword());
        if (user != null) {
            request.getSession().setAttribute(AppConsts.CURRENT_USER_ATTRIBUTE, user);
            return Response.ok(RestResult.getOk()).build();
        } else {
            return Response.ok(RestResult.getBad()).build();

        }
    }

    @POST
    @Path("logout")
    @Produces(MediaType.APPLICATION_JSON)
    public Response logout(@Context HttpServletRequest request) {
        if (request.getSession().getAttribute(AppConsts.CURRENT_USER_ATTRIBUTE) != null) {
            request.getSession().removeAttribute("currentUser");
            return Response.ok(RestResult.getOk()).build();
        }else{
            return Response.ok(RestResult.getBad()).build();
        }
    }

    @GET
    @Path("getCurrentUser")
    @Produces(MediaType.APPLICATION_JSON)
    public User getCurrentUser(@Context HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("currentUser");
        if(user != null){
            user.setPassword(null);
            user.setPassword2(null);
        }
        return user;
    }

    @GET
    @Path("isAuthenticated")
    @Produces(MediaType.APPLICATION_JSON)
    public Response isAuthenticated(@Context HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("currentUser");
        return Response.ok(user != null ? RestResult.getOk() : RestResult.getBad()).build();
    }
}

class LoginDto {
    private String username;
    private String password;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

