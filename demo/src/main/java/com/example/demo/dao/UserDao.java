package com.example.demo.dao;

import com.example.demo.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserDao{
    int insertUser(UUID id, User user);
    default int addUser(User user){
        UUID id = UUID.randomUUID();
        return insertUser(id, user);
    }
    List<User> selectAllUser();

    int deleteUserById(UUID ID);

    int updateUserById(UUID id, User user);

    Optional<User> selectUserById(UUID id);
    
}