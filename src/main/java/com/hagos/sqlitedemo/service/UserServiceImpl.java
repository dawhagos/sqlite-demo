package com.hagos.sqlitedemo.service;

import com.hagos.sqlitedemo.model.User;
import com.hagos.sqlitedemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public String createUser(User user) {
        try {
            if (!userRepository.existsByEmail(user.getEmail())) {
                user.setId(null == userRepository.findMaxId() ? 0 : userRepository.findMaxId() + 1);
                userRepository.save(user);
                return "User record created successfully";
            } else {
                return "User record already exists";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<User> readUsers() {
        return userRepository.findAll();
    }

}
