package com.timetracker.service.User;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.beans.factory.annotation.Autowired;

import com.timetracker.dto.Activity;
import com.timetracker.repository.UserRepository;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;  

@Target({TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = ValidUserValidator.class)
public @interface ValidUser {
    String message() default "Incorrect";
    Class[] groups() default{};
    Class[] payload() default{};
}
