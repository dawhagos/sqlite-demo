package com.hagos.sqlitedemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping(value = "info", method = RequestMethod.GET)
    public String info() {
        return "the application is up...";
    }
}
