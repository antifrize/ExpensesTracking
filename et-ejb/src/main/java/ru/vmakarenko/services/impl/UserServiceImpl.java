package ru.vmakarenko.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.vmakarenko.common.AppConsts;
import ru.vmakarenko.common.LoginPassCheckResult;
import ru.vmakarenko.entities.User;
import ru.vmakarenko.services.ExpensesService;
import ru.vmakarenko.services.UserService;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by VMakarenko on 2/4/15.
 */
@Stateless
@Local(UserService.class)
@Named
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @PersistenceContext
    EntityManager em;

    @Override
    public User getByPrincipal(String username) {
        List<User> userList = em.createQuery("select u from User u where u.username like :username", User.class)
                .setParameter("username", username)
                .getResultList();
        return userList.size() > 0 ? userList.get(0) : null;
    }

    @Override
    public void createUser(User user) {
        user.setPassword2(null);
        em.persist(user);
    }

    @Override
    public LoginPassCheckResult validateUsername(String username){
        String msg = null;
        if(!username.matches("\\w+")){
            msg = AppConsts.LOGIN_ERROR_ALPHANUMERIC;
        }else if(!username.matches("\\w{6,}")){
            msg = AppConsts.LOGIN_ERROR_SHORT;
        }else if(!username.matches("\\w{6,40}")){
            msg = AppConsts.LOGIN_ERROR_LONG;
        }else if( getByPrincipal(username) != null){
            msg = AppConsts.LOGIN_ERROR_NOT_UNIQUE;
        }
        LoginPassCheckResult result = new LoginPassCheckResult();
        return msg==null
                ? result.status(AppConsts.RESPONSE_OK)
                : result.status(AppConsts.RESPONSE_ERROR).field("username").msg(msg);
    }



    @Override
    public LoginPassCheckResult vaidateUser(User user){
        if(user != null){
            LoginPassCheckResult result = validateUsername(user.getUsername());
            if(result.getStatus().equals(AppConsts.RESPONSE_OK)){
                if(!user.getPassword().equals(user.getPassword2())){
                    result.field("password").status(AppConsts.RESPONSE_ERROR).msg(AppConsts.PASSWORD_ERROR_NOT_EQUALS);
                }
                if(!user.getPassword().matches("\\w+")){
                    result.field("password").status(AppConsts.RESPONSE_ERROR).msg(AppConsts.PASSWORD_ERROR_NOT_EQUALS);
                }

            }
            return result;
        }else{
            logger.error("Null user passed as a parameter!");
            throw new IllegalArgumentException("Null user passed as a parameter!");
        }


    }

}
