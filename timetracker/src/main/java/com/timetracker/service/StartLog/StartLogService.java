package com.timetracker.service.StartLog;

import java.time.Instant;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.timetracker.dto.StartLog;

@Service
public interface StartLogService {
    StartLog create(StartLog startLog);

    List<StartLog> read();

    List<StartLog> readByUserID(String userID);

    List<StartLog> readByUserIDTimeFrame(String userID, Instant start, Instant end);

    Map<String, Long> userLogsTimeFrame(String userID, Instant start, Instant end);

    StartLog update(StartLog startLog);

    StartLog changeTimeByID(String id, Instant newTime);

    Map<String, String> delete(String id);
}
