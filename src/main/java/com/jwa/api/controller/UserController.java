package com.jwa.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jwa.api.payload.response.ApiResponseObject;
import com.jwa.api.payload.response.UserBasicResponseObject;
import com.jwa.repository.UserRepository;
import com.jwa.security.CurrentUser;
import com.jwa.security.UserObject;
import com.jwa.service.UserService;

/**
 * 
 * @author John Anderson
 *
 * Controller to handle all of the user information
 */
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserService userService;

    /**
     * Getting the current users 
     * 
     * @param currentUser the current user information
     * @return UserBasicResponseObject gets the basic user information
     */
    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public UserBasicResponseObject getCurrentUser(@CurrentUser UserObject currentUser) {
    	return userService.getCurrentUserInformation(currentUser);
    }
    
    /**
     * Checks if the user name is not taken
     * 
     * @param username the user name to check if is available 
     * @return AvailableResponse return true if successful else returns false
     */
    @GetMapping("/user/checkUsernameAvailable")
    public ApiResponseObject checkUsernameAvailable(@RequestParam(value = "username") String username) {
        return userService.checkUsernameAvailable(username);
    }
    
    /**
     * Checks if the email is not taken
     * 
     * @param email the email to check if is available 
     * @return AvailableResponse return true if successful else returns false
     */
    @GetMapping("/user/checkEmailAvailable")
    public ApiResponseObject checkEmailAvailable(@RequestParam(value = "email") String email) {
    	return userService.checkEmailAvailable(email);
    }
}
