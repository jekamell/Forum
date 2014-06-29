package com.jekamell.crud.forum.validator;

import com.jekamell.crud.forum.model.User;
import com.jekamell.crud.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UniqueEmailValidator implements Validator {
    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        if (!(userService.getUserByEmail(user.getEmail()) == null
            || user.getId() == userService.getUserByEmail(user.getEmail()).getId())
        ) {
            errors.rejectValue("email", "", "This email address already taken"); // TODO: message sources
        }
    }
}
