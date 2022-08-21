package com.natwest.stock.user.model;

import com.natwest.stock.user.enitty.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserResponse {
    User user;
    List<Error> errors;
}
