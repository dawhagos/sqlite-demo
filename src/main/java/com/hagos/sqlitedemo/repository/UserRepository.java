package com.hagos.sqlitedemo.repository;

import com.hagos.sqlitedemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    boolean existsByEmail(String email);

    List<User> findByEmail(String email);

    @Query("select max(s.id) from User s")
    public Integer findMaxId();

}
