package com.timetracker.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.timetracker.service.Activity.ValidActivity;

//Activity DTO, used to store an activity with a title / userID
@Document
@ValidActivity
public class Activity {
    @Id
    String id;
    String userID;
    String title;

    public Activity() {
    }

    public Activity(String userID, String title) {
        this.userID = userID;
        this.title = title;
    }


    public String getId() {
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

    public void setUserID(String newUserID) {
        this.userID = newUserID;
    }

    public void setId(String newId) {
        this.id = newId;
    }

}
