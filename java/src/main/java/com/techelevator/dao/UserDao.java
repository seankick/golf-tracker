package com.techelevator.dao;

import com.techelevator.model.User;

import java.util.List;

public interface UserDao {

    List<User> findAll();

    User getUserById(Integer userId);

    User findByUsername(String username);

    Integer findIdByUsername(String username);

    boolean create(String username, String password, String role);
}
