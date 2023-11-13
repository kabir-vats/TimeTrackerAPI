package com.timetracker.controller;

import java.time.Instant;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.timetracker.service.StartLog.StartLogService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

import com.timetracker.dto.Activity;
import com.timetracker.dto.StartLog;

@RestController
@RequestMapping("/api/startLogs")
@CrossOrigin(origins = "*")

public class StartLogController {
    @Autowired
    private StartLogService startLogService;

    @PostMapping()
    public Object saveStartLog(@RequestBody @Valid StartLog startLog, BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response) {
        if (bindingResult.hasErrors()) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return ControllerErrorsHelper.processErrors(bindingResult);
        }
        else {
            response.setStatus(HttpServletResponse.SC_OK);
            return startLogService.create(startLog);
        }
    }

    @GetMapping()
    public List<StartLog> getAllStartLogs() {
        return startLogService.read();
    }

    @GetMapping("/userID/{userID}")

    public List<StartLog> getUserStartLogs(@PathVariable String userID) {
        return startLogService.readByUserID(userID);
    }

    @GetMapping("/activityLogs/{userID}")

    public List<StartLog> getUserStartLogsTimeFrame(@PathVariable @Valid String userID, 
        @RequestParam(value = "from") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant from
        , @RequestParam(value = "to") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant to) {
        return startLogService.readByUserIDTimeFrame(userID, from, to);
    }

    @GetMapping("/userTimes/{userID}")

    public Map<String, Long> getUserActivityTimes(@PathVariable @Valid String userID, 
        @RequestParam(value = "from") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant from
        , @RequestParam(value = "to") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant to) {
        return startLogService.userLogsTimeFrame(userID, from, to);
    }

    @PutMapping()

    public Object updatestartLog(@RequestBody StartLog startLog, BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response) {
        if (bindingResult.hasErrors()) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return ControllerErrorsHelper.processErrors(bindingResult);
        }
        else {
            response.setStatus(HttpServletResponse.SC_OK);
            return startLogService.update(startLog);
        }
    }

    @PatchMapping("/{id}")

    public StartLog changeTime(@PathVariable String id, @RequestBody Instant newTime) {
        return startLogService.changeTimeByID(id, newTime);
    }

    @DeleteMapping("/{id}")

    public Map<String, String> deletestartLog(@PathVariable String id) {

        return startLogService.delete(id);
    }
}
