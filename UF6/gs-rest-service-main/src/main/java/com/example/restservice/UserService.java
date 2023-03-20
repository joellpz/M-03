package com.example.restservice;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private List<User> llistaUsers = new ArrayList<>();

    public UserService() {
        llistaUsers.add(new User(1, "user1@ejemplo.com","User 1","1234"));
        llistaUsers.add(new User(2, "user2@ejemplo.com","User 2","1234"));
        llistaUsers.add(new User(3, "user3@ejemplo.com","User 3","1234"));
    }

    public List<User> getAllUsers(){
        return llistaUsers;
    }

    public void newUser(User user) {
        llistaUsers.add(user);
    }

    public void deleteUser(User user) {
        llistaUsers.remove(user);
    }
}
