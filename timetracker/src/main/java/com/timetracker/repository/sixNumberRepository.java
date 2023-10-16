package com.timetracker.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.*;
import com.timetracker.dto.sixNumber;

@Repository
public interface sixNumberRepository extends MongoRepository<sixNumber, String>{
}
