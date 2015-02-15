package ru.vmakarenko.common;

/**
 * Created by VMakarenko on 2/7/15.
 */
public class AppConsts {
    public static final String CURRENT_USER_ATTRIBUTE = "currentUser";
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String TIME_FORMAT = "HH:mm";

    public static final String LOGIN_ERROR_SHORT = "Login should contain at least 6 alphanumeric symbols";
    public static final String LOGIN_ERROR_ALPHANUMERIC = "Login should contain only alphanumeric symbols";
    public static final String LOGIN_ERROR_LONG = "Login is too long (max 40 chars)";
    public static final String LOGIN_ERROR_NOT_UNIQUE = "Login is already used, please take another one";


    public static final String RESPONSE_OK = "OK";
    public static final String RESPONSE_ERROR = "ERROR";

    public static final String PASSWORD_ERROR_NOT_EQUALS = "Passwords are different!";
    public static final String PASSWORD_ERROR_ALPHANUMERIC = "Password should contain only alphanumeric symbols";
}
