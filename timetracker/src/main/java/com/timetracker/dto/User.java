package com.timetracker.dto;

import java.time.Instant;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonCreator;

@Document
public class User {
    @Id
    private String id;
    private String username;
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

    public ZoneId getTimeZone() {
        return userTimeZone;
    }

    public void setUsername(String newUsername) {
        this.username = newUsername;
    }

    public void setUserTimeZone(ZoneId newTimeZone) {
        this.userTimeZone = newTimeZone;
    }


}
