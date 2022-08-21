package com.natwest.stock.pricing.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfiguration {
    @Autowired
    APIMetricLoggingFilter filter;

    @Bean
    public FilterRegistrationBean<APIMetricLoggingFilter> loggingFilter() {
        FilterRegistrationBean<APIMetricLoggingFilter> registrationBean
                = new FilterRegistrationBean<>();
        registrationBean.setFilter(filter);
        registrationBean.addUrlPatterns("/stock/*");
        registrationBean.setOrder(1);
        return registrationBean;
    }
}
