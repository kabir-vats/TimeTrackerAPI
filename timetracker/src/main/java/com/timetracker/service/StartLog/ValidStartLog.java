package com.timetracker.service.StartLog;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.beans.factory.annotation.Autowired;

import com.timetracker.dto.Activity;
import com.timetracker.repository.UserRepository;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;  ;

@Target({TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = ValidStartLogValidator.class)
public @interface ValidStartLog {
    String message() default "Incorrect";
    Class[] groups() default{};
    Class[] payload() default{};
}
