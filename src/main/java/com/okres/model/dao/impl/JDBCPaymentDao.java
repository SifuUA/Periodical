package com.okres.model.dao.impl;

import com.okres.model.dao.EditionDao;
import com.okres.model.dao.PaymentDao;
import com.okres.model.entity.Edition;
import com.okres.model.entity.Payment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class JDBCPaymentDao implements PaymentDao {

    private Connection connection;

    public JDBCPaymentDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Payment payment) throws SQLException {
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO periodical." +
                            "payment (amount, approve, edition_id, reader_id) " +
                            "VALUES (?,?,?,?)");
            preparedStatement.setInt(1, payment.getPaymentAmmount());
            preparedStatement.setBoolean(2, false);
            preparedStatement.setInt(3, payment.getEdition_id());
            preparedStatement.setInt(4, payment.getReader_id());
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            e.printStackTrace();
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
