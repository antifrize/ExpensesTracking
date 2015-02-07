package ru.vmakarenko.services.impl;

import org.springframework.beans.BeanUtils;
import ru.vmakarenko.entities.Expense;
import ru.vmakarenko.filter.ExpensesFilter;
import ru.vmakarenko.services.AuthService;
import ru.vmakarenko.services.ExpensesService;
import ru.vmakarenko.services.UserService;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.security.InvalidParameterException;
import java.util.List;

/**
 * Created by VMakarenko on 2/4/15.
 */
@Stateless
@Local(ExpensesService.class)
@Named
public class ExpensesServiceImpl implements ExpensesService {
    @PersistenceContext
    EntityManager em;
    @Inject
    UserService userService;

    @Override
    public Expense getById(Long id) {
        Expense expense =  em.getReference(Expense.class, id);
        return expense;
    }

    @Override
    public List<Expense> getAll(ExpensesFilter filter) {
        // TODO do some filtration
        filter.setUser(userService.getByPrincipal("user"));
        return em.createQuery(em.getCriteriaBuilder().createQuery(Expense.class)).getResultList();
    }

    @Override
    public void update(Expense expense) {
        if(expense.getId()!=null){
            Expense managedExpense = em.getReference(Expense.class, expense.getId());
            // TODO is evrth with version okay?
            BeanUtils.copyProperties(expense, managedExpense);
        }else{
            throw new InvalidParameterException("Cannot update expense with nulled id!");
        }

    }

    @Override
    public void create(Expense expense) {
        em.persist(expense);
    }
}
