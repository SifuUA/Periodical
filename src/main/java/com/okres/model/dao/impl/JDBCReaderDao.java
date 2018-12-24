package com.okres.model.dao.impl;

import com.okres.model.dao.ReaderDao;
import com.okres.model.dao.mapper.ReaderMapper;
import com.okres.model.entity.Reader;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JDBCReaderDao implements ReaderDao {

    private Connection connection;



    public JDBCReaderDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Reader entity) {

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
