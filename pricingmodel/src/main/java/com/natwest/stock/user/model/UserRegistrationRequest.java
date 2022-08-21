package com.natwest.stock.user.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Pattern;

@Getter
@Setter
public class UserRegistrationRequest {
    @Pattern(regexp = "^[a-zA-Z\\d-_]+$")
    String name;
    Subscription subscriptionType;

}
