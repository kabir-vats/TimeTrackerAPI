package com.timetracker.dto;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.timetracker.repository.UserRepository;
import com.timetracker.service.StartLog.ValidStartLog;

import jakarta.validation.constraints.NotBlank;

//Stores a log of a user starting a task
@Document
@CompoundIndex(def = "{'userID' = 1, 'timeStamp' = 1}")
@ValidStartLog
public class StartLog {

    @Id
    String id;
    String userID;
    String activityID;
    Instant timeStamp;

    @JsonCreator
    public StartLog(String userID, String activityID) {
        this.userID = userID;
        this.activityID = activityID;
        this.timeStamp = Instant.now();
    }


    public String getID() {
        return id;
    }

    public String getUserID() {
        return userID;
    }

    public String getActivityID() {
        return activityID;
    }

    public Instant getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Instant newTimeStamp) {
        timeStamp = newTimeStamp;
    }
}
