package com.timetracker.service.Activity;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.timetracker.dto.Activity;

@Service
public interface ActivityService {
    Activity create(Activity activity);

    List<Activity> read();

    List<Activity> readByUserID(String userID);

    Activity update(Activity activity);

    Map<String, String> delete(String id);
}
