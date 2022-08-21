package com.natwest.stock.pricing.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface StockPriceService {
    BigDecimal findFuturePrice(String ticker, LocalDate fromDate, LocalDate toDate);
}
