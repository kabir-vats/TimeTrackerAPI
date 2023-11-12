package com.timetracker.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
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
@CrossOrigin(origins = "*")

public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping()
    public User saveUser(@RequestBody @Validated User user) {
        return userService.create(user);
    }

    @GetMapping()

    public List<User> getAllUsers() {

        return userService.read();
    }

    @GetMapping("/username/{username}")

    public List<User> getUserbyUsername(@PathVariable String userName) {
        return userService.readByUsername(userName);
    }

    @PutMapping()

    public User updateUser(@RequestBody User user) {

        return userService.update(user);
    }

    @DeleteMapping("/{id}")

    public Map<String, String> deleteUser(@PathVariable String id) {

        return userService.delete(id);
    }
}