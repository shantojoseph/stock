package com.natwest.stock.pricing.filter;

import com.natwest.stock.pricing.repository.UserActivityRepository;
import com.natwest.stock.user.enitty.UserActivity;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@Component
@Log4j2
public class APIMetricLoggingFilter extends OncePerRequestFilter {

    @Autowired
    private UserActivityRepository userActivityRepository;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        logStockPricingActivity(request);
        filterChain.doFilter(request, response);
    }

    private void logStockPricingActivity(HttpServletRequest request) {
        String ticker = request.getParameter("ticker");
        String userId = request.getHeader("userId");
        UserActivity userActivity = new UserActivity();
        userActivity.setActivityDate(LocalDateTime.now());
        userActivity.setStockSymbol(ticker);
        userActivity.setUserId(Long.valueOf(userId));
        userActivityRepository.save(userActivity);
    }
}

