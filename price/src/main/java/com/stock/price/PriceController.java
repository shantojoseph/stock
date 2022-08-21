package com.stock.price;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class PriceController {
    @GetMapping(value = "/price")
    public BigDecimal getPrice() {
        return BigDecimal.valueOf(Math.random());
    }

}
