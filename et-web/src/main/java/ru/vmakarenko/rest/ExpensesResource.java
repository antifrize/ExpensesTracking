package ru.vmakarenko.rest;

import com.sun.istack.internal.NotNull;
import ru.vmakarenko.entities.Expense;
import ru.vmakarenko.filter.ExpensesFilter;
import ru.vmakarenko.services.ExpensesService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.List;

/**
 * Created by VMakarenko on 2/4/15.
 */

@Path("expenses")
public class ExpensesResource {
    @Inject
    ExpensesService expensesService;

    @GET
    @Path("{id: \\d+}")
    public Expense getById(@PathParam(value = "id") @NotNull Long id){
        return expensesService.getById(id);
    }

    @GET
    public List<Expense> getAll(ExpensesFilter filter){
        return expensesService.getAll(filter);
    }

    @PUT
    public Response updateExpense(Expense expense){
        expensesService.update(expense);
        return Response.ok().build();
    }

    @POST
    public Response createExpense(Expense expense){
        expensesService.create(expense);
        return Response.ok().build();
    }

}
