package me.kainar.awsm.service;

import me.kainar.awsm.dao.*;
import me.kainar.awsm.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserDAO userDAO;

    public void registerUser(String username, String password, String name){

    }

    public User getUser(Long id){
        return userDAO.getUserById(id);
    }

    public User getUser(String username){
        return userDAO.getUserByUsername(username);
    }



    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
}
