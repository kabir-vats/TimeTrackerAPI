package com.timetracker.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
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
import com.timetracker.service.User.ValidUserValidator;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

import com.timetracker.dto.Activity;
import com.timetracker.dto.User;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")

public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private ValidUserValidator userValidator;

    @PostMapping()
    public Object saveUser(@RequestBody @Valid User user, BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response) {
        if (bindingResult.hasErrors()) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return ControllerErrorsHelper.processErrors(bindingResult);
        }
        else {
            response.setStatus(HttpServletResponse.SC_OK);
            return userService.create(user);
        }
    }

    @GetMapping()

    public List<User> getAllUsers() {

        return userService.read();
    }

    @GetMapping("/username/{username}")

    public List<User> getUserbyUsername(@PathVariable String username) {
        return userService.readByUsername(username);
    }

    @PutMapping()

    public Object updateUser(@RequestBody @Valid User user, BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response) {
        if (bindingResult.hasErrors()) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return ControllerErrorsHelper.processErrors(bindingResult);
        }
        else {
            response.setStatus(HttpServletResponse.SC_OK);
            return userService.update(user);
        }
    }

    @DeleteMapping("/{id}")

    public Map<String, String> deleteUser(@PathVariable String id) {

        return userService.delete(id);
    }
}