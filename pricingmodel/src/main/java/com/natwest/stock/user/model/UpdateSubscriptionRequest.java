package com.natwest.stock.user.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateSubscriptionRequest {
    Long userId ;
    Subscription subscriptionType;
}
