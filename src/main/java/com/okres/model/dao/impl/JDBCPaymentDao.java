package com.okres.model.dao.impl;

import com.okres.model.dao.PaymentDao;
import com.okres.model.entity.Payment;
import com.okres.model.service.PropertyHolder;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @author O.Kres
 * @version 1.0
 * @project Periodical
 * @since 1/13/2019
 */

public class JDBCPaymentDao implements PaymentDao {
    private Connection connection;
    private PropertyHolder propertyHolder = new PropertyHolder();
    private static Logger logger = Logger.getLogger(JDBCPaymentDao.class);

    JDBCPaymentDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Payment payment) throws SQLException {
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement =
                    connection.prepareStatement(propertyHolder.getPropValues("insert.into.periodical"));
            preparedStatement.setInt(1, payment.getPaymentAmmount());
            preparedStatement.setBoolean(2, false);
            preparedStatement.setInt(3, payment.getEdition_id());
            preparedStatement.setInt(4, payment.getReader_id());
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException | IOException e) {
            connection.rollback();
            logger.error("Cant insert into periodical: " + e);
        }
    }

    @Override
    public void confirmSubscription(String readerFirstName, String readerLastName, String editionName) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareCall(propertyHolder.getPropValues("update.payment"));
            preparedStatement.setString(1, readerFirstName);
            preparedStatement.setString(2, readerLastName);
            preparedStatement.setString(3, editionName);
            preparedStatement.executeUpdate();
        } catch (SQLException | IOException e) {
            logger.error("Cant update payment: " + e);
        }
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
