package com.timetracker.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.timetracker.service.User.UserService;
import com.timetracker.dto.User;

@RestController
@RequestMapping("/api/users")

public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping()
    @CrossOrigin(origins = "http://localhost:5173")
    public User saveUser(@RequestBody User user) {
        return userService.create(user);
    }

    @GetMapping()
    @CrossOrigin(origins = "http://localhost:5173")
    public List<User> getAllUsers() {

        return userService.read();
    }

    @GetMapping("/username/{username}")
    @CrossOrigin(origins = "http://localhost:5173")
    public List<User> getUserbyUsername(@PathVariable String userName) {
        return userService.readByUsername(userName);
    }

    @PutMapping()
    @CrossOrigin(origins = "http://localhost:5173")
    public User updateUser(@RequestBody User user) {

        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:5173")
    public Map<String, String> deleteUser(@PathVariable String id) {

        return userService.delete(id);
    }
}