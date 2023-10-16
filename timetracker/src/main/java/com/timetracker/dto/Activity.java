package com.timetracker.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonCreator;

@Document
public class Activity {
    @Id
    String id;
    String userID;
    String title;

    @JsonCreator
    public Activity(String userID, String title) {
        this.userID = userID;
        this.title = title;
    }

    public String getActivityID() {
        return id;
    }

    public String getUserID() {
        return userID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String newTitle) {
        this.title = newTitle;
    }

}
