package com.timetracker.service.Activity;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.timetracker.dto.Activity;
import com.timetracker.repository.UserRepository;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Component
public class ValidActivityValidator implements ConstraintValidator<ValidActivity, Activity> {
    @Autowired
    private UserRepository userRepository;
    

    @Override
    public void initialize (ValidActivity annotation) {
        
    }

    @Override
    public boolean isValid(Activity value, ConstraintValidatorContext context) {
        boolean valid = true;
        if (value.getUserID() == null){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("userID must not be null")
                .addConstraintViolation();
            valid = false;
        }
        else if (!userRepository.existsById(value.getUserID())) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("userID must be valid")
                .addConstraintViolation();
            valid = false;
        }
        if (value.getTitle() == null) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("title must not be null")
                .addConstraintViolation();
            valid = false;
        }
        else if (value.getTitle().length() < 3 || value.getTitle().length() > 20) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("title must be between 3 and 20 characters")
                .addConstraintViolation();
            valid = false;
        }

        return valid;
    }




}
