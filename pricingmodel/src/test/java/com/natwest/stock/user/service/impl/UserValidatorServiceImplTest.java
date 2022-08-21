package com.natwest.stock.user.service.impl;

import com.natwest.stock.user.service.UserValidatorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
@Sql(statements = {"insert into users values (1,'shanto',1);"})
class UserValidatorServiceImplTest {

    @Autowired
    UserValidatorService userValidatorService;

    @Test
    void validate() {
        assertDoesNotThrow(() -> {
            userValidatorService.validate(1L);
        });
    }

}