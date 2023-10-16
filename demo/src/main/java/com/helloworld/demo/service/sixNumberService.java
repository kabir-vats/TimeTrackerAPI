package com.helloworld.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.helloworld.demo.dto.sixNumber;

@Service
public interface sixNumberService {
    sixNumber create(sixNumber sixNumber);

    List<sixNumber> read();

    sixNumber update(sixNumber sixNumber);

    Map<String, String> delete(String id);
}
