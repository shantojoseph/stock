package com.natwest.stock.pricing.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StockResponse {
    Stock stock;
    List<Error> errors;
}
