package com.natwest.stock.user.service;

import com.natwest.stock.user.enitty.User;
import com.natwest.stock.user.model.UpdateSubscriptionRequest;
import com.natwest.stock.user.model.UserRegistrationRequest;


public interface UserRegistrationService {
    User register(UserRegistrationRequest userRegistrationRequest);

    User updateSubscription(UpdateSubscriptionRequest subscriptionRequest) throws Exception;

}
