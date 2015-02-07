package ru.vmakarenko.services.impl;

import ru.vmakarenko.services.AuthService;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Named;

/**
 * Created by VMakarenko on 2/4/15.
 */

@Stateless
@Local(AuthService.class)
@Named
public class AuthServiceImpl implements AuthService {
}
