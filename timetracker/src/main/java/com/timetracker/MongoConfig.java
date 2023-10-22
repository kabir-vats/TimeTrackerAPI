package com.timetracker;

import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

public class MongoConfig extends AbstractMongoClientConfiguration{

    @Override
    protected String getDatabaseName() {
        return "sixNumbers";
    }

    @Override
    protected boolean autoIndexCreation() {
        return true;
    }
    
}
