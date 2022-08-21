package com.natwest.stock.user.service.impl;

import com.natwest.stock.user.dao.impl.LimitsDaoImpl;
import com.natwest.stock.user.model.CallLimit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LimitsServiceImplTest {

    @InjectMocks
    private LimitsServiceImpl limitsService;

    @Mock
    private LimitsDaoImpl limitsDao;


    @Mock
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Test
    void findStockLimits() {

    }

    @Test
    void findCallLimits() {

        CallLimit limit = new CallLimit();
        limit.setMaxCalls(1L);
        limit.setMultiplier(1L);
        limit.setUnit("second");
        when(limitsDao.findCallLimits(anyLong())).thenReturn(limit);
         CallLimit callLimit = limitsService.findCallLimits(1L);
         Assertions.assertEquals(callLimit.getUnit(), limit.getUnit());
    }
}