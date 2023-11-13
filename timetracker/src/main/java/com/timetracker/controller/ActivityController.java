package com.timetracker.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators.Log;
import org.springframework.http.HttpStatusCode;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.timetracker.service.Activity.ActivityService;
import com.timetracker.service.Activity.ValidActivityValidator;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

import com.timetracker.dto.Activity;

@RestController
@RequestMapping("/api/activities")
@CrossOrigin(origins = "*")

public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @Autowired
    private ValidActivityValidator activityValidator;


    @PostMapping()
    @Operation
    public Object saveActivity(@RequestBody @Valid Activity activity, BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response) {
        if (bindingResult.hasErrors()) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return ControllerErrorsHelper.processErrors(bindingResult);
        }
        else {
            response.setStatus(HttpServletResponse.SC_OK);
            return activityService.create(activity);
        }
    }

    @GetMapping()
    public List<Activity> getAllActivities() {
        return activityService.read();
    }

    @GetMapping("/userID/{userID}")
    public List<Activity> getUserActivities(@PathVariable String userID) {
        return activityService.readByUserID(userID);
    }

    @PutMapping()
    public Object updateActivity(@RequestBody @Valid Activity activity, BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response) {
        if (bindingResult.hasErrors()) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return ControllerErrorsHelper.processErrors(bindingResult);
        }
        else {
            response.setStatus(HttpServletResponse.SC_OK);
            return activityService.update(activity);
        }
    }

    @DeleteMapping("/{id}")
    public Map<String, String> deleteactivity(@PathVariable String id) {

        return activityService.delete(id);
    }

}
