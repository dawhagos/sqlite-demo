package com.hagos.sqlitedemo.service;

import com.hagos.sqlitedemo.model.User;

import java.util.List;

public interface UserService {
    String createUser(User user);

    List<User> readUsers();

    String updateUser(User user);

    String deleteUser(User user);
}
