package com.okres.model.dao.impl;

import com.okres.model.dao.ReaderDao;
import com.okres.model.dao.mapper.ReaderMapper;
import com.okres.model.entity.Reader;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        return null;
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
