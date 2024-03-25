package com.example.viikkoyhdeksikko;

import java.util.ArrayList;

import android.content.Context;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;

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
        saveUsersToFile();
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void loadUsersFromFile(Context context) {
        try (ObjectInputStream ois = new ObjectInputStream(context.openFileInput("users.data"))) {
            users = (ArrayList<User>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void saveUsersToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("users.data"))) {
            oos.writeObject(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<User> getSortedUsersByLastName() {
        Collections.sort(users, (user1, user2) -> user1.getLastName().compareTo(user2.getLastName()));
        return users;
    }
}