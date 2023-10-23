package com.timetracker.service.StartLog;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.timetracker.dto.StartLog;
import com.timetracker.repository.StartLogRepository;

@Service
public class StartLogServiceImpl implements StartLogService{

    @Autowired
    private StartLogRepository startLogRepository;

    @Override
    public StartLog create(StartLog startLog) {
        return startLogRepository.insert(startLog);
    }

    @Override
    public List<StartLog> read() {
        return startLogRepository.findAll();
    }

    @Override
    public List<StartLog> readByUserID(String userID) {
        return startLogRepository.findByUserID(userID);
    }


    @Override
    public List<StartLog> readByUserIDTimeFrame(String userID, Instant start, Instant end) {
        List<StartLog> timeStamps = startLogRepository.findByUserIDAndTimeStampBetweenOrderByTimeStampAsc(userID, start, end);
        if (timeStamps.size() == 0) {
            return timeStamps;
        }
        List<StartLog> dayBefore = startLogRepository.findByUserIDAndTimeStampBetweenOrderByTimeStampAsc(userID,start.minus(1, ChronoUnit.DAYS),start);
        if (dayBefore.size() == 0) {
            return timeStamps;
        }
        dayBefore.get(dayBefore.size()-1).setTimeStamp(start);
        timeStamps.add(0,dayBefore.get(dayBefore.size()-1));
        return timeStamps;
    }


    @Override
    public Map<String, Long> userLogsTimeFrame(String userID, Instant start, Instant end) {
        List<StartLog> timeStamps = readByUserIDTimeFrame(userID, start, end);
        Map<String,Long> userLogs = new HashMap<>();
        int sz = timeStamps.size();
        if (sz == 0) {
            return userLogs;
        }
        for (int i = 0; i < sz - 1; i++) {
            userLogs.put(timeStamps.get(i).getActivityID(),timeStamps.get(i).getTimeStamp().until(timeStamps.get(i+1).getTimeStamp(), ChronoUnit.SECONDS));
        }
        userLogs.put(timeStamps.get(sz-1).getActivityID(), timeStamps.get(sz-1).getTimeStamp().until(end, ChronoUnit.SECONDS));
        return userLogs;
    }

    @Override
    public StartLog update(StartLog startLog) {
        return startLogRepository.save(startLog);
    }

    @Override
    public StartLog changeTimeByID(String id, Instant newTime) {
        Optional<StartLog> toChange = startLogRepository.findById(id);
        if (toChange.isPresent()) {
            toChange.get().setTimeStamp(newTime);
        }
        return startLogRepository.save(toChange.get());
    }

    @Override
    public Map<String, String> delete(String id) {
        long beforeDelete = startLogRepository.count();
        startLogRepository.deleteById(id);
        long afterDelete = startLogRepository.count();
        String messageValue = beforeDelete == afterDelete ? "Something went wrong!" : "Record deleted";
        Map<String, String> deleteMap = new HashMap<>();
        deleteMap.put("message", messageValue);
        return deleteMap;
    }
    
}
