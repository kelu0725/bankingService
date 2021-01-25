package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.model.User;

import org.springframework.stereotype.Repository;

@Repository("sqlUserDataAccess")
public class sqlUserDataAccess implements UserDao {
    private static List<User> db = new ArrayList<User>();

    @Override
    public int insertUser(UUID id, User user) {
        db.add(new User(id, user.getName()));
        return 1;
    }

    @Override
    public List<User> selectAllUser() {
        return db;
    }

    @Override
    public int deleteUserById(UUID id) {
        Optional<User> userMaybe = selectUserById(id);
        if(userMaybe.isPresent()){
            db.remove(userMaybe.get());
            return 1;
        }
        return 0;
    }

    @Override
    public int updateUserById(UUID id, User user) {
        return selectUserById(id)
               .map(u -> {
                   int idxOfUser = db.indexOf(user);
                   if(idxOfUser >=0){
                       db.set(idxOfUser, user);
                       return 1;
                   }
                    return 0;
               }).orElse(0);
    }

    @Override
    public Optional<User> selectUserById(UUID id) {
        return db.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }
    
}
