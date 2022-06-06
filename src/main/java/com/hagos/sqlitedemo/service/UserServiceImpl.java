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

    @Transactional
    public String updateUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            try {
                List<User> users = userRepository.findByEmail(user.getEmail());
                users.stream().forEach(s -> {
                    User updatedUser = userRepository.findById(s.getId()).get();
                    updatedUser.setEmail(user.getEmail());
                    updatedUser.setUsername(user.getUsername());
                    userRepository.save(updatedUser);
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            return "User does not exist...";
        }
        return null;
    }

    @Transactional
    public String deleteUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            try {
                List<User> users = userRepository.findByEmail(user.getEmail());
                users.stream().forEach(s -> userRepository.delete(s));
                return "User record deleted successfully";
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            return "User does not exist...";
        }
        return null;
    }

}
