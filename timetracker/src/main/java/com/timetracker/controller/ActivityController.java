package com.timetracker.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.timetracker.service.Activity.ActivityService;

import io.swagger.v3.oas.annotations.Operation;

import com.timetracker.dto.Activity;

@RestController
@RequestMapping("/api/activities")
@CrossOrigin(origins = "*")

public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @PostMapping()
    @Operation
    public Activity saveActivity(@RequestBody Activity activity) {
        return activityService.create(activity);
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
    public Activity updateactivity(@RequestBody Activity activity) {

        return activityService.update(activity);
    }

    @DeleteMapping("/{id}")
    public Map<String, String> deleteactivity(@PathVariable String id) {

        return activityService.delete(id);
    }
}
