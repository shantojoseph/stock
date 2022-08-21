package com.natwest.stock.user.dao;

import com.natwest.stock.user.model.CallLimit;
import com.natwest.stock.user.model.StockLimit;

public interface LimitsDao {

    StockLimit findStockLimits(Long subscriptionId);

    CallLimit findCallLimits(Long subscriptionId);

}
