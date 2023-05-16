package com.example.ejemplo.Managers;

import java.util.List;

import com.example.ejemplo.models.UnAssignedTask;
import com.example.ejemplo.models.User;

import java.util.ArrayList;

public class UserManager {
    private static UserManager instanceUserManager;
    private List<User> users;

    private UserManager() {
        super();
    }

    public static UserManager getInstance() {
        if (instanceUserManager == null) {
            instanceUserManager = new UserManager();
        }
        return UserManager.instanceUserManager;
    }

    public User createUser(String name, String email) {
        if (this.users == null) {
            this.users = new ArrayList<User>();
        }
        return new User(name, email);
    }

    public boolean removeUser(int id){
        boolean result = false;
        if(this.users != null && !this.users.isEmpty()){
            result = 
        }
        return result;
    }

}
