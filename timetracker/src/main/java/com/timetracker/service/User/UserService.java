package com.timetracker.service.User;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.timetracker.dto.StartLog;
import com.timetracker.dto.User;

@Service
public interface UserService {
    User create(User user);

    List<User> read();

    List<User> readByUsername(String username);

    User update(User user);

    Map<String, String> delete(String id);
}
