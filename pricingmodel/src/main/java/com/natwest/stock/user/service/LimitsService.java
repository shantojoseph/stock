package com.natwest.stock.user.service;

import com.natwest.stock.user.model.CallLimit;
import com.natwest.stock.user.model.StockLimit;

public interface LimitsService {

    StockLimit findStockLimits(Long subscriptionId);

    CallLimit findCallLimits(Long subscriptionId);
}
