package com.hagos.sqlitedemo.controller;

import com.hagos.sqlitedemo.model.User;
import com.hagos.sqlitedemo.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@Tag(name = "Users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/createuser", method = RequestMethod.POST)
    public String createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @RequestMapping(value = "/readusers", method = RequestMethod.GET)
    public List<User> getUsers() {
        return userService.readUsers();
    }
}
