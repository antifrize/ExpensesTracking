package ru.vmakarenko.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import ru.vmakarenko.common.AppConsts;
import ru.vmakarenko.entities.Expense;
import ru.vmakarenko.entities.ExpensesFilter;
import ru.vmakarenko.entities.User;
import ru.vmakarenko.services.ExpensesService;
import ru.vmakarenko.services.UserService;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.security.InvalidParameterException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by VMakarenko on 2/4/15.
 */
@Stateless
@Local(ExpensesService.class)
@Named
public class ExpensesServiceImpl implements ExpensesService {
    private static final Logger logger = LoggerFactory.getLogger(ExpensesServiceImpl.class);
    @PersistenceContext
    EntityManager em;

    @Inject
    UserService userService;

    @Override
    public Expense getById(Long id) {
        Expense expense = em.getReference(Expense.class, id);
        return expense;
    }

    @Override
    public List<Expense> getAll(ExpensesFilter filter) {
        if (filter == null) {
            filter = new ExpensesFilter();
        }
        String query = "select e from Expense e left join e.user u where 1=1 " + getWhereClause(filter);
        return fillParameters(em.createQuery(query, Expense.class), filter).getResultList();
    }

    private TypedQuery<Expense> fillParameters(TypedQuery<Expense> query, ExpensesFilter filter) {
        SimpleDateFormat sdf = new SimpleDateFormat(AppConsts.DATE_FORMAT);
        try {
            if (filter.getDateFrom() != null) {
                query.setParameter("dateFrom", sdf.parse(filter.getDateFrom()));
            }
            if (filter.getDateTo() != null) {
                query.setParameter("dateTo", sdf.parse(filter.getDateTo()));
            }
        } catch (ParseException e) {
            logger.error("Illegal date from filter!");
            throw new RuntimeException(e);
        }
        return query;
    }

    private String getWhereClause(ExpensesFilter filter) {
        StringBuilder result = new StringBuilder();
        if (filter.getAmountMax() != null) {
            result.append(" and e.amount <= ").append(filter.getAmountMax());
        }
        if (filter.getAmountMin() != null) {
            result.append(" and e.amount >= ").append(filter.getAmountMin());
        }
        if (filter.getDescription() != null) {
            result.append(" and e.description like '%").append(filter.getDescription()).append("%'");
        }
        if (filter.getComment() != null) {
            result.append(" and e.comment like '%").append(filter.getComment()).append("%'");
        }
        if (filter.getUser() != null) {
            result.append(" and u.username like '").append(filter.getUser().getUsername()).append("'");
        }
        if (filter.getDateFrom() != null) {
            result.append(" and e.dateTime >= :dateFrom");
        }
        if (filter.getDateTo() != null) {
            result.append(" and e.dateTime <= :dateTo");
        }
        return result.toString();
    }

    @Override
    public Expense update(Expense expense) {
        if (expense.getId() != null) {
            Expense managedExpense = em.getReference(Expense.class, expense.getId());
            BeanUtils.copyProperties(expense, managedExpense, "user","version");
            // TODO is evrth with version okay?
            expense = em.merge(managedExpense);
        } else {
            throw new InvalidParameterException("Cannot update expense with nulled id!");
        }
        return expense;
    }

    @Override
    public Expense create(Expense expense, User user) {
        expense.setUser(user);
        em.persist(expense);
        return expense;
    }

    @Override
    public void delete(Long id) {
        Expense expense =
                em.getReference(Expense.class, id);
        if (expense != null) {
            em.remove(expense);
        } else {
            throw new RuntimeException("Wrong id!");
        }
    }
}
