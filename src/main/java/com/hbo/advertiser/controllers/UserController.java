package com.hbo.advertiser.controllers;

import com.hbo.advertiser.Exceptions.UserNotFoundException;
import com.hbo.advertiser.documents.User;
import com.hbo.advertiser.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final IUserRepository userRepo;

    @Autowired
    public UserController(IUserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @PostMapping("/add")
    public User addUser(@RequestBody User user) throws UserNotFoundException {
        if (user != null) {
            userRepo.save(user);
        }
        return user;
    }

    @PutMapping("/update/{id}")
    public void updateUser(@PathVariable(name = "id") Long id, @RequestBody User user) throws UserNotFoundException {
        if (id != null) {
            User u = userRepo.getById(id);
            if (u != null) {
                user = userRepo.save(user);
            }
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable(name = "id") Long id) throws UserNotFoundException {
        User u = userRepo.getById(id);
        if (u != null) {
            userRepo.delete(u);
        }
    }

    @GetMapping("/user/{id}")
    public User getUser (@PathVariable (name = "id") Long id) throws UserNotFoundException {
        User u = userRepo.getById(id);
        if (u != null) {
            return u;
        }
        return u;
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

}
