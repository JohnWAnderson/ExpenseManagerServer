package com.jwa.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import com.jwa.api.payload.request.LoginRequestObject;
import com.jwa.api.payload.request.SignUpRequestObject;
import com.jwa.service.UserService;
/**
 * 
 * @author John Anderson
 * Controllers the user account creation and logging in to the api
 */
@RestController
@RequestMapping("/api/auth")
public class AccountController {
    @Autowired
    UserService userService;

    /**
     * Gets login information change will return a jwt token if successful 
     * @param loginRequest The request payload object that has the information to login
     * @return a jwt token
     */
    @PostMapping("/signin")
    public ResponseEntity<?> signinUser(@Valid @RequestBody LoginRequestObject loginRequest) {
        return userService.loginRequest(loginRequest);
    }
      
    /**
     * Gets account information add attempts to add account into the database 
     * @param signUpRequest The request payload object to with new account information 
     * @return if the account was created successfully
     */
	@PostMapping("/signup")
    public ResponseEntity<?> signupUser(@Valid @RequestBody SignUpRequestObject signUpRequest) {	
		return userService.signupRequest(signUpRequest);
    }
}