package com.natwest.stock.pricing.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Stock {
    BigDecimal price;
    String ticker;
}
