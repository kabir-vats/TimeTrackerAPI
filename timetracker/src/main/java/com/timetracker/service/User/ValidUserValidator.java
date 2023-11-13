package com.timetracker.service.User;

import java.time.Instant;
import java.util.Set;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.timetracker.dto.Activity;
import com.timetracker.dto.User;
import com.timetracker.repository.UserRepository;
import com.timetracker.service.Activity.ValidActivity;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


@Component
public class ValidUserValidator implements ConstraintValidator<ValidUser, User>{
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public void initialize (ValidUser annotation) {

    }

    @Override
    public boolean isValid(User value, ConstraintValidatorContext context) {
        boolean valid = true;
        if (value.getUsername() == null) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("username must not be null")
                .addConstraintViolation();
            valid = false;
        }
        else if (value.getUsername().length() < 3 || value.getUsername().length() > 14) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("username must be between 3 and 14 characters")
                .addConstraintViolation();
            valid = false;
        }
        else if (!userRepository.findByUsername(value.getUsername()).isEmpty()) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("username already in use")
                .addConstraintViolation();
            valid = false;
        }
        if (value.getUserTimeZone() == null) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("userTimeZone must not be null")
                .addConstraintViolation();
            valid = false;
        }
        else if (Set.of(TimeZone.getAvailableIDs()).contains(value.getUserTimeZone())) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("userTimeZone must be a valid TimeZone")
                .addConstraintViolation();
            valid = false;
        }
        return valid;
    }

}
