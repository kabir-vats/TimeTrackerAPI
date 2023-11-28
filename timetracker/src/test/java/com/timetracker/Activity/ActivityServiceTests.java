package com.timetracker.Activity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.timetracker.dto.Activity;
import com.timetracker.repository.ActivityRepository;
import com.timetracker.service.Activity.ActivityService;
import com.timetracker.service.Activity.ActivityServiceImpl;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;

@SpringBootApplication(exclude = {
    MongoAutoConfiguration.class, 
    MongoDataAutoConfiguration.class
})
@ExtendWith(MockitoExtension.class)
public class ActivityServiceTests {
    String userID = "123456";
    List<Activity> activityRepoMock;

    @Mock
    private ActivityRepository activityRepository;
    
    @Mock 
    private Validator validator;

    @InjectMocks
    private ActivityServiceImpl activityService;

    @BeforeEach
    public void setUp() {
        activityRepoMock = new ArrayList<Activity>();

        
        /* 
        Mockito.when(activityRepository.findByUserID(userID))
            .thenReturn(activityRepoMock);*/
        
        
    }

    @Test
    public void testCreate() {
        Activity activity = new Activity(userID, "Valid Title");
        Mockito.when(activityRepository.insert(Mockito.any(Activity.class)))
            .thenAnswer(invocation -> invocation.getArgument(0));
        Set<ConstraintViolation<Activity>> noErrors = new HashSet<ConstraintViolation<Activity>>();
        Mockito.when(validator.validate(Mockito.any(Activity.class)))
            .thenReturn(noErrors);

        assertEquals(activity, activityService.create(activity));
    }

}
