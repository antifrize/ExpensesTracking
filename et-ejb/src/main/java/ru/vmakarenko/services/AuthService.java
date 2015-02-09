package ru.vmakarenko.services;

/**
 * Created by VMakarenko on 2/4/15.
 */
public interface AuthService {
    public boolean isAuthorized(String authId, String authToken );
}
