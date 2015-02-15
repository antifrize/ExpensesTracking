package ru.vmakarenko.services;

import ru.vmakarenko.entities.Expense;
import ru.vmakarenko.entities.ExpensesFilter;
import ru.vmakarenko.entities.User;

import java.util.List;

/**
 * Created by VMakarenko on 2/4/15.
 */
public interface ExpensesService {

    Expense getById(Long id);

    List<Expense> getAll(ExpensesFilter filter);

    Expense update(Expense expense);

    Expense create(Expense expense, User user);

    void delete(Long id);
}
