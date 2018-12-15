package com.okres.model.dao.mapper;

import com.okres.model.entity.Payment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class PaymentMapper implements ObjectMapper<Payment> {

    @Override
    public Payment extractFromResultSet(ResultSet rs) throws SQLException {
        return null;
    }

    @Override
    public Payment makeUnique(Map<Integer, Payment> cache, Payment teacher) {
        return null;
    }
}
