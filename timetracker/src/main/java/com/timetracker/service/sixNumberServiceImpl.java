package com.timetracker.service;

import com.timetracker.dto.sixNumber;
import com.timetracker.repository.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class sixNumberServiceImpl implements sixNumberService{

    @Autowired
    private sixNumberRepository sixNumberRepository;

    @Override
    public sixNumber create(sixNumber sixNumber) {
        return sixNumberRepository.insert(sixNumber);
    }

    @Override
    public List<sixNumber> read() {
        return sixNumberRepository.findAll();
    }

    @Override
    public sixNumber update (sixNumber sixNumber) {
        return sixNumberRepository.save(sixNumber);
    }

    @Override
    public Map<String, String> delete (String id) {
        long beforeDelete = sixNumberRepository.count();
        sixNumberRepository.deleteById(id);
        long afterDelete = sixNumberRepository.count();
        String messageValue = beforeDelete == afterDelete ? "Something went wrong!" : "Record deleted";
        Map<String, String> deleteMap = new HashMap<>();
        deleteMap.put("message", messageValue);
        return deleteMap;
    }
}
