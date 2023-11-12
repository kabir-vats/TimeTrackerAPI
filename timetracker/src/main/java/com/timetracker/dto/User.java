package com.timetracker.dto;

import java.time.ZoneId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonCreator;

//Stores a user's timezone, id, and username. Password / auth not implemented yet.
@Document
public class User {
    @Id
    private String id;
    @NonNull
    private String username;
    @NonNull
    ZoneId userTimeZone;

    @JsonCreator
    public User(String username, ZoneId userTimeZone) {
        this.username = username;
        this.userTimeZone = userTimeZone;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public ZoneId getUserTimeZone() {
        return userTimeZone;
    }

    public void setUsername(String newUsername) {
        this.username = newUsername;
    }

    public void setUserTimeZone(ZoneId newTimeZone) {
        this.userTimeZone = newTimeZone;
    }


}
