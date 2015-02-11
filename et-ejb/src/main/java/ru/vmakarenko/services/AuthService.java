package ru.vmakarenko.services;

import ru.vmakarenko.entities.User;

/**
 * Created by VMakarenko on 2/4/15.
 */
public interface AuthService {
    User login(String login, char[] password);

    public boolean isAuthorized(String authId, String authToken );
}
