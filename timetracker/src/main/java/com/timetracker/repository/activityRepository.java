package com.timetracker.repository;

import java.util.List;
import com.timetracker.dto.Activity;

import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface ActivityRepository extends MongoRepository<Activity, String>{
    public List<Activity> findByUserID(String userID);
}
