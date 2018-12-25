package com.okres.model.dao;

import com.okres.model.entity.Payment;

import java.sql.SQLException;
import java.util.List;

public interface PaymentDao extends GenericDao<Payment>{
    @Override
    void create(Payment entity) throws SQLException;

    @Override
    Payment findById(int id);

    @Override
    List<Payment> findAll();

    @Override
    void update(Payment entity);

    @Override
    void delete(int id);

    @Override
    void close();
}
