package com.natwest.stock.pricing.controller;


import com.natwest.stock.pricing.Service.StockPriceService;
import com.natwest.stock.pricing.model.Error;
import com.natwest.stock.pricing.model.Stock;
import com.natwest.stock.pricing.model.StockResponse;
import com.natwest.stock.user.repository.UserRepository;
import com.natwest.stock.user.service.UserValidatorService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class StockPriceController {

    private final UserValidatorService userValidatorService;

    private final UserRepository userRepository;

    private final StockPriceService stockPriceService;

    public StockPriceController(UserValidatorService userValidatorService, UserRepository userRepository, StockPriceService stockPriceService) {
        this.userValidatorService = userValidatorService;
        this.userRepository = userRepository;
        this.stockPriceService = stockPriceService;
    }

    @GetMapping(path = "/stock/price")
    public ResponseEntity<StockResponse> getFuturePrice(@RequestParam @Pattern(regexp = "([A-Za-z]+):([A-Za-z]+)", message = "Invalid format for ticker") String ticker, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) String fromDate, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) String toDate, @RequestHeader("userId") Long userId) {
        Stock stock = new Stock();
        StockResponse response = new StockResponse();
        BigDecimal stockPrice;
        try {
            userValidatorService.validate(userId);
            stockPrice = stockPriceService.findFuturePrice(ticker, LocalDate.now(), LocalDate.now());
            stock.setPrice(stockPrice);
            stock.setTicker(ticker);
            response.setStock(stock);
        } catch (Exception e) {
            response = getErrorResponse(e);
            return new ResponseEntity<>(response, HttpStatus.UNPROCESSABLE_ENTITY);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private StockResponse getErrorResponse(Exception e) {
        StockResponse response = new StockResponse();
        List<Error> errorList = new ArrayList<>();
        Error error = new Error();
        error.setCode("999");
        error.setDescription(e.getLocalizedMessage());
        errorList.add(error);
        response.setErrors(errorList);
        return response;
    }
}
