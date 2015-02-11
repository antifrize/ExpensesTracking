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
    @Path("/checkLogin")
    @Produces(MediaType.APPLICATION_JSON)
    public Response checkLogin(@QueryParam(value = "login") String login){
        String msg = null;
        if(!login.matches("\\w+")){
            msg = AppConsts.LOGIN_ERROR_ALPHANUMERIC;
        }else if(!login.matches("\\w{3,}")){
            msg = AppConsts.LOGIN_ERROR_SHORT;
        }else if(!login.matches("\\w{3,40}")){
            msg = AppConsts.LOGIN_ERROR_LONG;
        }else if( userService.getByPrincipal(login) != null){
            msg = AppConsts.LOGIN_ERROR_NOT_UNIQUE;
        }
        LoginCheckResult lcr = new LoginCheckResult();
        lcr.setMsg(msg);
        lcr.setOk(msg == null);
        return Response.ok(lcr).build();

    }


    @POST
    public Response createUser(User user){
        // TODO validation
        userService.createUser(user);
        return Response.ok().build();
    }



}

class LoginCheckResult{
    private boolean ok;
    private String msg;

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
