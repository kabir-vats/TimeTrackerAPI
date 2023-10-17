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

import com.timetracker.service.Activity.ActivityService;
import com.timetracker.dto.Activity;

@RestController
@RequestMapping("/api/activities")

public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @PostMapping()
    @CrossOrigin(origins = "http://localhost:5173")
    public Activity saveActivity(@RequestBody Activity activity) {
        return activityService.create(activity);
    }

    @GetMapping()
    @CrossOrigin(origins = "http://localhost:5173")
    public List<Activity> getAllActivities() {
        return activityService.read();
    }

    @GetMapping("/userID/{userID}")
    @CrossOrigin(origins = "http://localhost:5173")
    public List<Activity> getUserActivities(@PathVariable String userID) {
        return activityService.readByUserID(userID);
    }

    @PutMapping()
    @CrossOrigin(origins = "http://localhost:5173")
    public Activity updateactivity(@RequestBody Activity activity) {

        return activityService.update(activity);
    }

    @DeleteMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:5173")
    public Map<String, String> deleteactivity(@PathVariable String id) {

        return activityService.delete(id);
    }
}
