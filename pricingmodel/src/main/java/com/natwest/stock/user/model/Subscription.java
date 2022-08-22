package com.natwest.stock.user.model;

public enum Subscription {
    GOLD("1"),
    SILVER("2"),
    DEMO("3");
    public final String value;

    Subscription(String value) {
        this.value = value;
    }
}
