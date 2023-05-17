package com.example.ejemplo.Managers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.ejemplo.models.User;

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

    public boolean removeUser(int id) {
        boolean result = false;
        if (this.users != null && !this.users.isEmpty()) {
            // TODO Mejorar
            List<User> finds = this.users.stream().filter(x -> x.getId() != id).collect(Collectors.toList());
            users = finds;
        }
        return result;
    }

}
