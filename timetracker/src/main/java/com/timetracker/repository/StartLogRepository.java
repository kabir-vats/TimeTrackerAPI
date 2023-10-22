package com.timetracker.repository;

import java.time.Instant;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.timetracker.dto.StartLog;

@Repository
public interface StartLogRepository extends MongoRepository<StartLog, String>{
    public List<StartLog> findByUserID(String userID);

    public List<StartLog> findByUserIDandTimeStampBetween(String userID, Instant from, Instant to);
}
