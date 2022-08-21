package com.natwest.stock.user.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CallLimit {
    private Long maxCalls;
    private String unit;
    private Long multiplier;
}
