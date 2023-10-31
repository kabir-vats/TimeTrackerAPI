package com.timetracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.Index;

import jakarta.annotation.PostConstruct;

/*Class to get indexes initialized and working for startLog*/
@Configuration
@DependsOn("mongoTemplate")
public class CollectionsConfig {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private MongoOperations mongoOperations;
    
    @PostConstruct
    public void initIndexes() {
        mongoTemplate.indexOps("startLog")
            .ensureIndex(
                new Index().on("userID", Sort.Direction.ASC).on("timeStamp",Sort.Direction.ASC)
            );
        mongoOperations.indexOps("startLog")
            .ensureIndex(
                new Index().on("userID", Sort.Direction.ASC).on("timeStamp",Sort.Direction.ASC)
            );
    }
}
