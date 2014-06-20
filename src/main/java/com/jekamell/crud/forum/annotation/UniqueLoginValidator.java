package com.jekamell.crud.forum.annotation;

import com.jekamell.crud.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueLoginValidator implements ConstraintValidator<UniqueLogin, String> {

    @Autowired
    private UserService userService;

    @Override
    public void initialize(UniqueLogin uniqueLogin) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (userService == null) {
            return true;
        }

        return userService.getUserByUserName(s) == null;
    }
}
