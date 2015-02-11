package ru.vmakarenko.services.impl;

import ru.vmakarenko.entities.User;
import ru.vmakarenko.services.AuthService;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import java.util.List;

/**
 * Created by VMakarenko on 2/4/15.
 */

@Stateless
@Local(AuthService.class)
@Named
public class AuthServiceImpl implements AuthService {

    @PersistenceContext
    EntityManager em;

    @Override
    public User login(String login, char[] password) {
        // TODO create normal query
        List<User> userList = em.createQuery("select u from User u where u.username like '" + login+ "' and u.password like '" + new String(password) + "'", User.class ).getResultList();
        return userList.size() > 0 ? userList.get(0) : null;
    }

    public User logout() {
        return null;
    }


    @Override
    public boolean isAuthorized(String authId, String authToken) {
        return false;
    }
}
