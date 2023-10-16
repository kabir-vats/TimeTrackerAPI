package com.timetracker.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Document
public class sixNumber {

    @Id 
    private String id;
    private int givenNumber;
    private int multipliedNumber;

    @JsonCreator
    public sixNumber (@JsonProperty("givenNumber") int givenNumber) {
        this.givenNumber = givenNumber;
        this.multipliedNumber = givenNumber * 6;
    }

    public String getID() {
        return id;
    }

    public int getGivenNumber() {
        return givenNumber;
    }

    public int getMultipliedNumber() {
        return multipliedNumber;
    }

    public void setGivenNumber(int newGiven) {
        givenNumber = newGiven;
        multipliedNumber = newGiven * 6;
    }
}
