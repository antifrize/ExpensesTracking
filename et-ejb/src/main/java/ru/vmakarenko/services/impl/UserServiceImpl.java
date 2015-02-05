package ru.vmakarenko.services.impl;

import ru.vmakarenko.entities.User;
import ru.vmakarenko.services.UserService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by VMakarenko on 2/4/15.
 */
public class UserServiceImpl implements UserService {
    @PersistenceContext
    EntityManager em;

    @Override
    public User getByPrincipal(String user) {
        List<User> userList = em.createQuery(em.getCriteriaBuilder().createQuery(User.class)).getResultList();
        return userList.size() > 0 ? userList.get(0) : null;
    }
}