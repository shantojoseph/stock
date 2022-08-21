package com.natwest.stock.user.controller;

import com.natwest.stock.user.enitty.User;
import com.natwest.stock.user.model.Error;
import com.natwest.stock.user.model.UpdateSubscriptionRequest;
import com.natwest.stock.user.model.UserRegistrationRequest;
import com.natwest.stock.user.model.UserResponse;
import com.natwest.stock.user.service.UserRegistrationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserRegistrationController {

    private final UserRegistrationService userRegistrationService;

    public UserRegistrationController(UserRegistrationService userRegistrationService) {
        this.userRegistrationService = userRegistrationService;
    }

    @PostMapping(path = "/user")
    public ResponseEntity<UserResponse> register(@RequestBody @Valid UserRegistrationRequest registrationRequest) {
        UserResponse response = new UserResponse();

        try {
            User user=   userRegistrationService.register(registrationRequest);
            response.setUser(user);
        } catch (Exception e) {
            response = getErrorResponse(e);
            return new ResponseEntity<>(response, HttpStatus.UNPROCESSABLE_ENTITY);
        }
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping(path = "/user")
    public ResponseEntity<UserResponse> update(@RequestBody @Valid UpdateSubscriptionRequest updateSubscriptionRequest) {
        UserResponse response = new UserResponse();
        try {
            User user = userRegistrationService.updateSubscription(updateSubscriptionRequest);
            response.setUser(user);
        } catch (Exception e) {
            response = getErrorResponse(e);
            return new ResponseEntity<>(response, HttpStatus.UNPROCESSABLE_ENTITY);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private UserResponse getErrorResponse(Exception exception) {
        UserResponse response = new UserResponse();
        List<Error> errorList = new ArrayList<>();
        Error error = new Error();
        error.setCode("999");
        error.setDescription(exception.getLocalizedMessage());
        errorList.add(error);
        response.setErrors(errorList);
        return response;
    }
}
