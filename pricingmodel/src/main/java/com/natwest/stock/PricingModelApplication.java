package com.natwest.stock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class PricingModelApplication {

    public static void main(String[] args) {
        SpringApplication.run(PricingModelApplication.class, args);
    }

}
