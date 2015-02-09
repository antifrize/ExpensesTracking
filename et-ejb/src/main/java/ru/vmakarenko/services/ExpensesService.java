package ru.vmakarenko.services;

import ru.vmakarenko.entities.Expense;
import ru.vmakarenko.entities.ExpensesFilter;

import java.util.List;

/**
 * Created by VMakarenko on 2/4/15.
 */
public interface ExpensesService {

    Expense getById(Long id);

    List<Expense> getAll(ExpensesFilter filter);

    void update(Expense expense);

    void create(Expense expense);

    void delete(Long id);
}
