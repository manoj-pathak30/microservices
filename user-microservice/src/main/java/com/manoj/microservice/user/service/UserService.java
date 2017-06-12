package com.manoj.microservice.user.service;

import com.manoj.microservice.user.domain.User;

import java.util.List;

/**
 * Created by synerzip on 25/5/17.
 */
public interface UserService {

    public List<User> getUsers();

    public User getUserByName(String userName);
}
