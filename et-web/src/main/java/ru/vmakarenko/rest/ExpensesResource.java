package ru.vmakarenko.rest;

import com.sun.istack.internal.NotNull;
import ru.vmakarenko.entities.Expense;
import ru.vmakarenko.filter.ExpensesFilter;
import ru.vmakarenko.services.ExpensesService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
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
    public List<Expense> getAll(ExpensesFilter filter){
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

}
