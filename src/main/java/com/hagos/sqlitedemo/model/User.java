package com.hagos.sqlitedemo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
public class User {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String email;

    @Column(name = "username", unique = true)
    private String username;

    public User() {
    }
}
