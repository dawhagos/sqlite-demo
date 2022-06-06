package com.hagos.sqlitedemo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@ToString
@Entity
public class User {
    @Id
    private Integer id;

    private String email;

    @Column(name = "username", unique = true)
    private String username;

    private String password;

    public User() {
    }
}
