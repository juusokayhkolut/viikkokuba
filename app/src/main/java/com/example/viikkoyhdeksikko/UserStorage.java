package com.example.viikkoyhdeksikko;

import java.util.ArrayList;

public class UserStorage {
    private ArrayList<User> users;
    private static UserStorage instance;

    private UserStorage() {
        users = new ArrayList<>();
    }

    public static UserStorage getInstance() {
        if (instance == null) {
            instance = new UserStorage();
        }
        return instance;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public ArrayList<User> getUsers() {
        return users;
    }
}