package com.jekamell.crud.forum.controller;

import com.jekamell.crud.forum.model.User;
import com.jekamell.crud.forum.service.UserService;
import com.jekamell.crud.forum.validators.UniqueEmailValidator;
import com.jekamell.crud.forum.validators.UniqueLoginValidator;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

@Controller
@Transactional(propagation = Propagation.SUPPORTS, readOnly= true)
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UniqueEmailValidator uniqueEmailValidator;
    @Autowired
    private UniqueLoginValidator uniqueLoginValidator;

    @RequestMapping(value = "/user/register", method = RequestMethod.GET)
    public String registrationForm(Model model) {
        model.addAttribute(new User());

        return "registration-form";
    }

    @RequestMapping(value = "/user/register", method = RequestMethod.POST)
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
    public String registerUser(@Valid User user,
                               BindingResult bindingResult,
                               @RequestParam(value = "avatar", required = false) MultipartFile image
    ) {

        if (bindingResult.hasErrors()) {
            return "registration-form";
        }

        userService.addUser(user);

        try {
            if (!image.isEmpty()) {
                validateImage(image);

                saveImage(user.getId() + ".jpg", image);
            }
        } catch (ImageUploadException e) {
            bindingResult.reject(e.getMessage());
            return "registration-form";

        }

        return "redirect:/";
    }

    @RequestMapping(value = "/profile/edit", method = RequestMethod.GET)
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public String changeProfileForm(Model model) {
        User user = userService.getCurrentUser();
        model.addAttribute(user);

        return "change-profile-form";
    }

    @RequestMapping(value = "/profile/edit", method = RequestMethod.POST)
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
    public String updateProfile(@Valid User user, BindingResult result, Model model) {
        User userCurrent = userService.getCurrentUser();
        userCurrent.setNameFirst(user.getNameFirst());
        userCurrent.setNameLast(user.getNameLast());
        userCurrent.setEmail(user.getEmail());
        userCurrent.setSkype(user.getSkype());

        uniqueEmailValidator.validate(userCurrent, result);
        uniqueLoginValidator.validate(userCurrent, result);

        if (result.hasErrors()) {
            model.addAttribute(userCurrent);
            return "change-profile-form";
        }

        userService.updateUser(userCurrent);

        return "redirect:/profile/edit?success=true";
    }

    private void validateImage(MultipartFile image) throws ImageUploadException {
        if (!image.getContentType().equals("image/jpeg")) {
            throw new ImageUploadException("Only JPG images accepted");
        }
    }

    private class ImageUploadException extends RuntimeException {
        private ImageUploadException(String message) {
            super(message);
        }
    }

    private void saveImage(String fileName, MultipartFile image) throws ImageUploadException {
        try {
            File file = new File(getWebRootPath() + "/resources/img/avatar/" + fileName);
            FileUtils.writeByteArrayToFile(file, image.getBytes());
        } catch (IOException e) {
            throw new ImageUploadException("Unable to save image");
        }
    }

    private String getWebRootPath() {
        return "/home/mell/IdeaProjects/forum/src/main/webapp";
    }
}
