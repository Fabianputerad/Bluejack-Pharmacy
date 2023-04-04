package com.example.projectasg;

import java.util.ArrayList;
import java.util.List;

public class UserController {
    private ArrayList<User> userList = new ArrayList<>();

    public void registerUser(String name, String email, String password) {
        User user = new User(name, email, password);
        userList.add(user);
    }

    public ArrayList<User> getUserList() {
        return userList;
    }
}
