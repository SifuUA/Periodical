package com.okres.model.dao.impl;

import com.okres.model.dao.EditionDao;
import com.okres.model.dao.PaymentDao;
import com.okres.model.entity.Edition;
import com.okres.model.entity.Payment;

import java.sql.Connection;
import java.util.List;

public class JDBCPaymentDao implements PaymentDao {

    private Connection connection;

    public JDBCPaymentDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Payment entity) {

    }

    @Override
    public Payment findById(int id) {
        return null;
    }

    @Override
    public List<Payment> findAll() {
        return null;
    }

    @Override
    public void update(Payment entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void close() {

    }
}
