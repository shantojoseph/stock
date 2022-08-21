package com.natwest.stock.user.dao.impl;

import com.natwest.stock.user.dao.LimitsDao;
import com.natwest.stock.user.model.CallLimit;
import com.natwest.stock.user.model.StockLimit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class LimitsDaoImpl implements LimitsDao {

    private static final String GET_STOCK_LIMIT = "select  b.id, max_stock , multiplier,unit from  STOCK_LIMIT_MODEL  a ,subscription_model b ,unit_model c where a.id=b.STOCK_LIMIT_MODEL_id and a.unit_model_id=c.id and b.id=:id";
    private static final String GET_CALL_LIMIT = "select  b.id, max_calls , multiplier ,unit from  CALL_LIMIT_MODEL  a ,subscription_model b ,unit_model c  where a.id=b.STOCK_LIMIT_MODEL_id and a.unit_model_id=c.id  and b.id=:id";
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public StockLimit findStockLimits(Long subscriptionId) {
        return jdbcTemplate.queryForObject(GET_STOCK_LIMIT, new MapSqlParameterSource()
                .addValue("id", subscriptionId), (rs, rowNum) -> {
            StockLimit stockLimit = new StockLimit();
            stockLimit.setMaxStock(rs.getLong("max_stock"));
            stockLimit.setId(rs.getLong("id"));
            stockLimit.setMultiplier(rs.getLong("multiplier"));
            stockLimit.setUnit(rs.getString("unit"));
            return stockLimit;
        });

    }

    @Override
    public CallLimit findCallLimits(Long subscriptionId) {
        return jdbcTemplate.queryForObject(GET_CALL_LIMIT, new MapSqlParameterSource()
                .addValue("id", subscriptionId), (rs, rowNum) -> {
            CallLimit callLimit = new CallLimit();
            callLimit.setMaxCalls(rs.getLong("max_calls"));
            callLimit.setMultiplier(rs.getLong("multiplier"));
            callLimit.setUnit(rs.getString("unit"));
            return callLimit;
        });
    }
}
