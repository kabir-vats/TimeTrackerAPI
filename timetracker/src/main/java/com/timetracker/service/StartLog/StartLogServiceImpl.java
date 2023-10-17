package com.timetracker.service.StartLog;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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
    public StartLog update(StartLog startLog) {
        return startLogRepository.save(startLog);
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
