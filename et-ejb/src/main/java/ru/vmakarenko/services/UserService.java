package ru.vmakarenko.services;

import ru.vmakarenko.entities.User;

/**
 * Created by VMakarenko on 2/4/15.
 */
public interface UserService {
    public User getByPrincipal(String user);

    void createUser(User user);
}
