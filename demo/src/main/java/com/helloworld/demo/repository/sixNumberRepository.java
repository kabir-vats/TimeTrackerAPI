package com.helloworld.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.*;
import com.helloworld.demo.dto.sixNumber;

@Repository
public interface sixNumberRepository extends MongoRepository<sixNumber, String>{
}
