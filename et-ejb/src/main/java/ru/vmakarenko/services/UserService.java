package ru.vmakarenko.services;

import ru.vmakarenko.common.LoginPassCheckResult;
import ru.vmakarenko.entities.User;

/**
 * Created by VMakarenko on 2/4/15.
 */
public interface UserService {
    public User getByPrincipal(String user);

    void createUser(User user);

    LoginPassCheckResult validateUsername(String username);

    LoginPassCheckResult vaidateUser(User user);
}
