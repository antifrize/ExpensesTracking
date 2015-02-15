package ru.vmakarenko.rest;

import ru.vmakarenko.common.AppConsts;
import ru.vmakarenko.entities.Expense;
import ru.vmakarenko.entities.ExpensesFilter;
import ru.vmakarenko.entities.User;
import ru.vmakarenko.services.ExpensesService;
import ru.vmakarenko.services.UserService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by VMakarenko on 2/4/15.
 */

@ApplicationScoped
@Path("user")
public class UserResource {

    @Inject
    private UserService userService;

    @GET
    @Path("checkLogin")
    @Produces(MediaType.APPLICATION_JSON)
    public Response checkLogin(@QueryParam(value = "login") String username){
        return Response.ok(userService.validateUsername(username)).build();

    }
}

