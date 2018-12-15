package com.okres.model.dao.impl;

import com.okres.model.dao.ReaderDao;
import com.okres.model.entity.Reader;

import java.sql.Connection;
import java.util.List;

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
}
