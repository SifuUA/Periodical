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

    @Override
    public void confirmSubscription(String readerFirstName, String readerLastName, String editionName) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareCall("UPDATE payment\n" +
                            "SET approve = TRUE\n" +
                            "WHERE payment.reader_id = (SELECT reader.id" +
                            "                           FROM reader" +
                            "                           WHERE first_name LIKE ?" +
                            "                             AND last_name LIKE ?)" +
                            "  AND payment.edition_id = (SELECT edition.id FROM edition WHERE name = ?)");

            preparedStatement.setString(1, readerFirstName);
            preparedStatement.setString(2, readerLastName);
            preparedStatement.setString(3, editionName);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
