package com.okres.model.dao;

import com.okres.model.entity.Payment;

import java.sql.SQLException;
import java.util.List;

/**
 * @author O.Kres
 * @version 1.0
 * @project Periodical
 * @since 1/13/2019
 */

public interface PaymentDao extends GenericDao<Payment> {
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

    void confirmSubscription(String readerFirstName, String readerLastName, String phone);
}
