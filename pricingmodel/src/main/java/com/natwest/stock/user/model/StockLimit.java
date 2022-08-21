package com.natwest.stock.user.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StockLimit {
    private Long id;
    private Long maxStock;
    private Long multiplier;
    private String unit;

}
