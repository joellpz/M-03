package com.example.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.quartz.QuartzTransactionManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UserResource.USER_RESOURCE)
public class UserResource {
    public static final String USER_RESOURCE = "/v1/users";

    @Autowired
    UserController userController;

    @GetMapping
    public List<User> getAllUsers() {
        return userController.readAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id){
        return userController.getUser(id);
    }

    @PostMapping
    public void addUser(@RequestBody User user){
        userController.addUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id){
        userController.deleteUser(userController.getUser(id));
    }
}
