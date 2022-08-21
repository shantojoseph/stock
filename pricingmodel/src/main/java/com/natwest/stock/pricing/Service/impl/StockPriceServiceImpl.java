package com.natwest.stock.pricing.Service.impl;

import com.natwest.stock.pricing.Service.StockPriceService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class StockPriceServiceImpl implements StockPriceService {

    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public BigDecimal findFuturePrice(String ticker, LocalDate fromDate, LocalDate toDate) {
        return restTemplate.getForObject("http://localhost:8081/price", BigDecimal.class);
    }
}
