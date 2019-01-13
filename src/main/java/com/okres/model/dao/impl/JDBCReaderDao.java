package com.okres.model.dao.impl;

import com.okres.model.dao.ReaderDao;
import com.okres.model.dao.mapper.ReaderMapper;
import com.okres.model.entity.Reader;
import com.okres.model.entity.enums.Role;
import com.okres.model.service.PropertyHolder;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * @author O.Kres
 * @version 1.0
 * @project Periodical
 * @since 1/13/2019
 */

public class JDBCReaderDao implements ReaderDao {
    private Connection connection;
    private PropertyHolder propertyHolder = new PropertyHolder();
    private static Logger logger = Logger.getLogger(JDBCReaderDao.class);

    JDBCReaderDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Reader read) throws SQLException {
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement =
                    connection.prepareStatement(propertyHolder.getPropValues("insert.into.reader"));
            preparedStatement.setString(1, read.getFirstName());
            preparedStatement.setString(2, read.getLastName());
            preparedStatement.setString(3, read.getPhoneNumber());
            preparedStatement.setString(4, read.getEmailAddress());
            preparedStatement.setString(5, read.getPassword());
            preparedStatement.setInt(6, read.getRole().equals(Role.ADMIN) ? 1 : 0);
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException | IOException e) {
            connection.rollback();
            logger.error("Cant insert reader: " + e);
        }
    }

    @Override
    public List<Reader> findAll() {
        List<Reader> readers = new ArrayList<>();
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        ReaderMapper readerMapper = new ReaderMapper();
        try {
            preparedStatement = connection.prepareCall(propertyHolder.getPropValues("select.reader"));
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                readers.add(readerMapper.extractFromResultSet(resultSet));
            }
        } catch (SQLException | IOException e) {
            logger.error("Cant select reader by role: " + e);
        }
        return readers;
    }

    @Override
    public Map<Integer, List<String>> findReaderPayments(int reader_id) {
        Map<Integer, List<String>> result = new HashMap<>();
        int count = 0;
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement(propertyHolder.getPropValues("select.reader.payments"));
            preparedStatement.setInt(1, reader_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            getSubscriptions(result, count, resultSet);
        } catch (SQLException | IOException e) {
            logger.error("Cant select reader payments by reader id: " + reader_id + " " + e);
        }
        return result;
    }

    @Override
    public Map<Integer, List<String>> findReadersPayments() {
        Map<Integer, List<String>> result = new HashMap<>();
        int count = 0;
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement(propertyHolder.getPropValues("select.reader.payments.all"));
            ResultSet resultSet = preparedStatement.executeQuery();
            getSubscriptions(result, count, resultSet);
        } catch (SQLException | IOException e) {
            logger.error("Cant select all reader payments:" + e);
        }
        return result;
    }

    private void getSubscriptions(Map<Integer, List<String>> result, int count, ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            List<String> list = new ArrayList<>();
            list.add(resultSet.getString(1));
            list.add(resultSet.getString(2));
            list.add(resultSet.getString(3));
            list.add(resultSet.getString(4));
            list.add(String.valueOf(resultSet.getInt(5)));
            list.add(resultSet.getBoolean(6) ? "Confirmed" : "Not confirmed");
            result.put(count++, list);
        }
    }

    @Override
    public Optional<Reader> findReaderByEmailAndPassword(String email, String password) {
        Optional<Reader> result = Optional.empty();
        ResultSet rs;
        ReaderMapper readerMapper;
        try {
            PreparedStatement ps = connection.prepareCall(propertyHolder.getPropValues("select.reader.by.email.password"));
            ps.setString(1, email);
            ps.setString(2, password);
            rs = ps.executeQuery();
            readerMapper = new ReaderMapper();
            if (rs.next()) {
                result = Optional.of(readerMapper.extractFromResultSet(rs));
            }
        } catch (SQLException | IOException e) {
            logger.error("Cant select all reader by email and password:" + e);
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public void update(Reader entity) {

    }

    @Override
    public Reader findById(int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void close() {

    }
}
