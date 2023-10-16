package com.timetracker.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonCreator;

@Document
public class User {
    @Id
    private String id;
    TimeZone userTimeZone;

    @JsonCreator
    public User(TimeZone userTimeZone) {
        this.userTimeZone = userTimeZone;
    }

    public String getId() {
        return id;
    }

    public TimeZone getTimeZone() {
        return userTimeZone;
    }

    public void setUserTimeZone(TimeZone newTimeZone) {
        this.userTimeZone = newTimeZone;
    }


}
