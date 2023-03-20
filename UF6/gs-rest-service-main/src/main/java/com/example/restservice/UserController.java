package com.example.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    public List<User> readAll() {
        return userService.getAllUsers();
    }

    public User getUser(int id) {
        Optional<User> optUser = userService.getAllUsers().stream().filter(u -> u.id() == id).findAny();
        //return userService.getAllUsers().get(id);
        if (optUser.isPresent()) return optUser.get();
        else  return null;
    }

    public void addUser(User user) {
        userService.newUser(user);
    }

    public void deleteUser(User user) {
        userService.deleteUser(user);
    }
}
