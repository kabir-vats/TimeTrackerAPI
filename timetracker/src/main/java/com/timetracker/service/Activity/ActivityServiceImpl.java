package com.timetracker.service.Activity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.timetracker.dto.Activity;
import com.timetracker.repository.ActivityRepository;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    @Override
    public Activity create(Activity activity) {
        return activityRepository.insert(activity);
    }

    @Override
    public List<Activity> read() {
        return activityRepository.findAll();
    }

    @Override
    public List<Activity> readByUserID(String userID) {
        return activityRepository.findByUserID(userID);
    }

    @Override
    public Activity update(Activity activity) {
        return activityRepository.save(activity);
    }

    @Override
    public Map<String, String> delete(String id) {
        long beforeDelete = activityRepository.count();
        activityRepository.deleteById(id);
        long afterDelete = activityRepository.count();
        String messageValue = beforeDelete == afterDelete ? "Something went wrong!" : "Record deleted";
        Map<String, String> deleteMap = new HashMap<>();
        deleteMap.put("message", messageValue);
        return deleteMap;
    }
}
