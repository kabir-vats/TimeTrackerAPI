package com.timetracker.service.StartLog;

import java.time.Instant;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.timetracker.dto.Activity;
import com.timetracker.dto.StartLog;

@Service
public interface StartLogService {
    StartLog create(StartLog startLog);

    List<StartLog> read();

    List<StartLog> readByUserID(String userID);

    StartLog update(StartLog startLog);

    StartLog updateTimeByUserID(String userID, Instant newTime);

    Map<String, String> delete(String id);
}
