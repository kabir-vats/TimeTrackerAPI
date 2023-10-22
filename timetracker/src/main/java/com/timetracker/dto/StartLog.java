package com.timetracker.dto;

import java.time.Instant;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@CompoundIndex(def = "{'userID' = 1, 'timeStamp' = 1}")
public class StartLog {
    @Id
    String id;
    String userID;
    String activityID;
    Instant timeStamp;

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
