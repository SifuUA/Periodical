package com.okres.model.dao.impl;

import com.okres.model.dao.ReaderDao;
import com.okres.model.dao.mapper.ReaderMapper;
import com.okres.model.entity.Reader;
import com.okres.model.entity.enums.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class JDBCReaderDao implements ReaderDao {

    private Connection connection;


    public JDBCReaderDao(Connection connection) {
        this.connection = connection;
    }

    ResultSet resultSet;

    @Override
    public void create(Reader read) throws SQLException {
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO periodical.reader (first_name, last_name, phone_number, email, password, role_id) VALUES (?,?,?,?,?,?)");
            System.out.println(read.toString());
            preparedStatement.setString(1, read.getFirstName());
            preparedStatement.setString(2, read.getLastName());
            preparedStatement.setString(3, read.getPhoneNumber());
            preparedStatement.setString(4, read.getEmailAddress());
            preparedStatement.setString(5, read.getPassword());
            preparedStatement.setInt(6, read.getRole().equals(Role.ADMIN) ? 1 : 0);
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            e.printStackTrace();
        }

    }

    @Override
    public Reader findById(int id) {
        return null;
    }

    @Override
    public List<Reader> findAll() {
        List<Reader> readers = new ArrayList<>();
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        ReaderMapper readerMapper = new ReaderMapper();
        try {
            preparedStatement = connection.prepareCall("SELECT * FROM periodical.reader where role_id = 0");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                readers.add(readerMapper.extractFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return readers;
    }

    @Override
    public void update(Reader entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void close() {

    }

    @Override
    public Map<Integer, List<String>> findReaderPayments(int reader_id) {
        Map<Integer, List<String>> result = new HashMap<>();
        int count = 0;

        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement(
                            "SELECT r.first_name, r.last_name, r.phone_number, e.name, e.price, p.approve\n" +
                                    "FROM periodical.reader AS r, periodical.payment AS p, periodical.edition AS e, periodical.edition_category AS ec\n" +
                                    "WHERE r.id = p.reader_id AND r.role_id = 0 AND e.id = p.edition_id AND e.category_id = ec.category_id AND r.id = ?");

            preparedStatement.setInt(1, reader_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            getSubscriptions(result, count, resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public Map<Integer, List<String>> findReadersPayments() {
        Map<Integer, List<String>> result = new HashMap<>();
        int count = 0;

        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement(
                            "SELECT r.first_name, r.last_name, r.phone_number, e.name, e.price, p.approve\n" +
                                    "FROM periodical.reader AS r, periodical.payment AS p, periodical.edition AS e, periodical.edition_category AS ec\n" +
                                    "WHERE r.id = p.reader_id AND r.role_id = 0 AND e.id = p.edition_id AND e.category_id = ec.category_id");

            ResultSet resultSet = preparedStatement.executeQuery();
            getSubscriptions(result, count, resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
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
            PreparedStatement ps = connection.prepareCall("SELECT * FROM periodical.reader WHERE email = ? AND password = ?");
            ps.setString(1, email);
            ps.setString(2, password);
            rs = ps.executeQuery();
            readerMapper = new ReaderMapper();
            if (rs.next()) {
                result = Optional.of(readerMapper.extractFromResultSet(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
