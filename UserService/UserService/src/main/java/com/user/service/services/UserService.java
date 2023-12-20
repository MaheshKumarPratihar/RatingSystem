package com.user.service.services;

import com.user.service.entities.User;

import java.util.List;

public interface UserService {

    // user operations

    // create
    User saveUser(User user);

    // get all User
    List<User> getAllUser();

    // get single User
    User getUser(String userId);

    // delete User
    String deleteUser(String userId);

    // update User
    User updateUser(User user);
}
