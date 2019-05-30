package com.homelab.romrominitializr.controllers;

import com.homelab.romrominitializr.User;
import com.homelab.romrominitializr.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class UserRestController {
    @Autowired
    private UserRepo repository;

    @PostMapping("/user-rest/create")
    public User createUser(User user) {
        user.setRegistrationDate(new Date());
        repository.save(user);
        return user;
    }

    @PutMapping("/user-rest")
    public User saveOrUpdateUser(@RequestBody User user){
        repository.save(user);
        return user;
    }

    @DeleteMapping("/user-rest/{id}")
    public void deleteUser(@PathVariable int id){
        repository.deleteById(id);
    }

    @GetMapping("/user-rest/{id}")
    public Optional<User> getUser(@PathVariable int id){
        return repository.findById(id);
    }

    @GetMapping("/users")
    public List<User> getUser(){
        return repository.findAll();
    }
}
