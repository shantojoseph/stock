package com.natwest.stock.user.service.impl;

import com.natwest.stock.user.dao.LimitsDao;
import com.natwest.stock.user.model.CallLimit;
import com.natwest.stock.user.model.StockLimit;
import com.natwest.stock.user.service.LimitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LimitsServiceImpl implements LimitsService {

    @Autowired
    LimitsDao limitsDao;

    @Override
    public StockLimit findStockLimits(Long subscriptionId) {
        return limitsDao.findStockLimits(subscriptionId);
    }

    @Override
    public CallLimit findCallLimits(Long subscriptionId) {
        return limitsDao.findCallLimits(subscriptionId);
    }
}
