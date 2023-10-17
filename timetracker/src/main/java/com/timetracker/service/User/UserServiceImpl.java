package com.timetracker.service.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.timetracker.dto.User;
import com.timetracker.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User create(User user) {
        return userRepository.insert(user);
    }

    @Override
    public List<User> read() {
        return userRepository.findAll();
    }

    @Override
    public List<User> readByUsername(String username){
        return userRepository.findByUsername(username);
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public Map<String, String> delete(String id) {
        long beforeDelete = userRepository.count();
        userRepository.deleteById(id);
        long afterDelete = userRepository.count();
        String messageValue = beforeDelete == afterDelete ? "Something went wrong!" : "Record deleted";
        Map<String, String> deleteMap = new HashMap<>();
        deleteMap.put("message", messageValue);
        return deleteMap;
    }
    
}
