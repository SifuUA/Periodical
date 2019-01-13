package com.okres.model.dao.mapper;

import com.okres.model.entity.Payment;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author O.Kres
 * @version 1.0
 * @project Periodical
 * @since 1/13/2019
 */

public class PaymentMapper implements ObjectMapper<Payment> {
    @Override
    public Payment extractFromResultSet(ResultSet rs) {
        return null;
    }
}
