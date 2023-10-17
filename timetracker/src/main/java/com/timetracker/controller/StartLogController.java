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

import com.timetracker.service.StartLog.StartLogService;
import com.timetracker.dto.StartLog;

@RestController
@RequestMapping("/api/startLogs")
public class StartLogController {
    @Autowired
    private StartLogService startLogService;

    @PostMapping()
    @CrossOrigin(origins = "http://localhost:5173")
    public StartLog saveStartLog(@RequestBody StartLog startLog) {
        return startLogService.create(startLog);
    }

    @GetMapping()
    @CrossOrigin(origins = "http://localhost:5173")
    public List<StartLog> getAllStartLogs() {
        return startLogService.read();
    }

    @GetMapping("/userID/{userID}")
    @CrossOrigin(origins = "http://localhost:5173")
    public List<StartLog> getUserStartLogs(@PathVariable String userID) {
        return startLogService.readByUserID(userID);
    }

    @PutMapping()
    @CrossOrigin(origins = "http://localhost:5173")
    public StartLog updatestartLog(@RequestBody StartLog startLog) {

        return startLogService.update(startLog);
    }

    @DeleteMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:5173")
    public Map<String, String> deletestartLog(@PathVariable String id) {

        return startLogService.delete(id);
    }
}
