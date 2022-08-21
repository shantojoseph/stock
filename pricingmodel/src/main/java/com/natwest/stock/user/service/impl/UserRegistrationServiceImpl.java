package com.natwest.stock.user.service.impl;

import com.natwest.stock.user.enitty.User;
import com.natwest.stock.user.model.UpdateSubscriptionRequest;
import com.natwest.stock.user.model.UserRegistrationRequest;
import com.natwest.stock.user.repository.UserRepository;
import com.natwest.stock.user.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public User register(UserRegistrationRequest userRegistrationRequest) {
        User user = userRepository.save(convertToUserEntity(userRegistrationRequest));
        return user;
    }

    @Override
    public User updateSubscription(UpdateSubscriptionRequest subscriptionRequest) throws Exception {
        Optional<User> user = userRepository.findById(subscriptionRequest.getUserId());
        if(user.isPresent())
        {
            user.get().setSubscriptionModelId(Long.valueOf(subscriptionRequest.getSubscriptionType().value));
           return userRepository.save(user.get());
        }
        else {
            throw new Exception("User not found ");
        }
    }

    private User convertToUserEntity(UserRegistrationRequest userRegistrationRequest) {
        User user = new User();
        user.setName(userRegistrationRequest.getName());
        user.setSubscriptionModelId(Long.valueOf(userRegistrationRequest.getSubscriptionType().value));
        return user;
    }
}
