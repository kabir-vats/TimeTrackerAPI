package com.timetracker.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

public class ControllerErrorsHelper {
    public static List<ObjectError> processErrors(BindingResult bindingResult) {
        List<String> message = new ArrayList<>();
        List<ObjectError> errors = bindingResult.getAllErrors();
        for (ObjectError e : errors) {
            message.add(e.toString());
        }
        return errors;
    }
}
