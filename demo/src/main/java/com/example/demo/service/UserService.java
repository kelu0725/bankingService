package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.dao.UserDao;
import com.example.demo.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserDao userDao;

    @Autowired
    public UserService(@Qualifier("sqlUserDataAccess") UserDao userDao) {
        this.userDao = userDao;
    }
    
    public int addUser(User user) {
        return userDao.addUser(user);
    }

    public List<User> getAllUsers(){
        return userDao.selectAllUser();
    }

    public Optional<User> getUser(UUID id){
        return userDao.selectUserById(id);
    }

    public int deleteUserById(UUID id){
        return userDao.deleteUserById(id);
    }

    public int updateUserById(UUID id, User user){
        return userDao.updateUserById(id, user);
    }
   
}
