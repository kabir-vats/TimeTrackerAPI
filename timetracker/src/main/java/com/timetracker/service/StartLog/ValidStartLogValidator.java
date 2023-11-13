package com.timetracker.service.StartLog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.timetracker.dto.StartLog;
import com.timetracker.repository.ActivityRepository;
import com.timetracker.repository.UserRepository;
import com.timetracker.service.Activity.ValidActivity;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Component
public class ValidStartLogValidator implements ConstraintValidator<ValidStartLog, StartLog>{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ActivityRepository activityRepository;

    @Override
    public void initialize(ValidStartLog annotation) {

    }

    @Override
    public boolean isValid(StartLog value, ConstraintValidatorContext context) {
        boolean valid = true;
        boolean userIDExists = true;
        if (value.getUserID() == null){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("userID must not be null")
                .addConstraintViolation();
            valid = false;
            userIDExists = false;
        }
        else if (!userRepository.existsById(value.getUserID())) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("userID must be valid")
                .addConstraintViolation();
            valid = false;
        }
        if (value.getActivityID() == null){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("activityID must not be null")
                .addConstraintViolation();
            valid = false;
        }
        else if (!activityRepository.existsById(value.getActivityID())) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("activityID must be valid")
                .addConstraintViolation();
            valid = false;
        }
        else if (userIDExists && (!(value.getUserID().equals(activityRepository.findById(value.getActivityID()).get().getUserID())))){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("activityID must belong to userID")
                .addConstraintViolation();
            valid = false;
        }
        return valid;
    }
}
