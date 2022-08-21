package com.natwest.stock.user.service.impl;

import com.natwest.stock.pricing.repository.UserActivityRepository;
import com.natwest.stock.user.enitty.User;
import com.natwest.stock.user.model.CallLimit;
import com.natwest.stock.user.model.StockLimit;
import com.natwest.stock.user.repository.UserRepository;
import com.natwest.stock.user.service.LimitsService;
import com.natwest.stock.user.service.UserValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserValidatorServiceImpl implements UserValidatorService {
    @Autowired
    private UserActivityRepository userActivityRepository;
    @Autowired
    private LimitsService limitsService;
    @Autowired
    private UserRepository userRepository;

    @Override
    public void validate(Long userId) throws Exception {

        Optional<User> user = userRepository.findById(userId);
        Long subscriptionId = user.get().getSubscriptionModelId();

        StockLimit stockLimit = limitsService.findStockLimits(subscriptionId);

        validateStockCalls(userId, stockLimit);

        CallLimit callLimit = limitsService.findCallLimits(subscriptionId);

        validateCallLimits(userId, callLimit);
    }

    private void validateStockCalls(Long userId, StockLimit stockLimit) throws Exception {
        LocalDateTime startDate = LocalDateTime.now().withDayOfMonth(1);
        LocalDateTime endDate = LocalDateTime.now().withDayOfMonth(31);

        Long noOfStockQueried = userActivityRepository.findStocksByUserIdAndPeriod(userId, startDate, endDate);

        if (noOfStockQueried >= stockLimit.getMaxStock()) {
            throw new Exception("No of stock you are authorized to query exceeded .Please upgrade your plan");
        }
    }

    private void validateCallLimits(Long userId, CallLimit callLimit) throws Exception {
        LocalDateTime startDateCall = LocalDateTime.now();
        LocalDateTime endDateCall = LocalDateTime.now();
        if (callLimit.getUnit().equals("month")) {
            startDateCall = LocalDateTime.now().withDayOfMonth(1);
            endDateCall = LocalDateTime.now().withDayOfMonth(31);
        } else if (callLimit.getUnit().equals("minute")) {
            startDateCall = LocalDateTime.now().withSecond(0);
            endDateCall = LocalDateTime.now().withSecond(59);
        }
        Long noOfCalls = userActivityRepository.findCallsByUserIdAndPeriod(userId, startDateCall, endDateCall);

        if (noOfCalls >= callLimit.getMaxCalls()) {
            throw new Exception("No of stock you are authorized to query exceeded .Please upgrade your plan");
        }
    }
}
