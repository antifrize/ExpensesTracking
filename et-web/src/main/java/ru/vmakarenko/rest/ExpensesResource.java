package ru.vmakarenko.rest;

import ru.vmakarenko.common.AppConsts;
import ru.vmakarenko.entities.Expense;
import ru.vmakarenko.entities.ExpensesFilter;
import ru.vmakarenko.entities.User;
import ru.vmakarenko.services.ExpensesService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by VMakarenko on 2/4/15.
 */

@ApplicationScoped
@Path("expenses")
public class ExpensesResource {
    @Inject
    private ExpensesService expensesService;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Expense getById(@PathParam(value = "id") Long id){
        return expensesService.getById(id);
    }

    @POST
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Expense> getAll(ExpensesFilter filter, @Context HttpServletRequest request){
        filter.setUser((User) request.getSession().getAttribute(AppConsts.CURRENT_USER_ATTRIBUTE));
        return expensesService.getAll(filter);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateExpense(Expense expense){
        expensesService.update(expense);
        return Response.ok().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createExpense(Expense expense){
        expensesService.create(expense);
        return Response.ok().build();
    }


    @DELETE
    @Path("/{id}")
    public Response deleteExpense(@PathParam(value = "id") Long id){
        expensesService.delete(id);
        return Response.ok().build();
    }

}
