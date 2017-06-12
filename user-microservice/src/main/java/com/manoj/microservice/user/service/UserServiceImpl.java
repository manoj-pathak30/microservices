package com.manoj.microservice.user.service;

import com.manoj.microservice.user.domain.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by synerzip on 25/5/17.
 */
@Service
public class UserServiceImpl implements UserService {

  List<User> userList = Arrays.asList(
      new User("manoj", "manoj", "pathak", "manoj@gmail.com"),
      new User("ayansh", "ayansh", "pathak", "ayansh@gmail.com")
  );

  @Override
  public List<User> getUsers() {
    return userList;
  }

  @Override
  public User getUserByName(String userName) {
    return userList.stream().filter(user -> user.getUserName().equals(userName))
        .findAny().get();
  }
}
