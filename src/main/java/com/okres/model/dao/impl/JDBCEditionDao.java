package com.okres.model.dao.impl;

import com.okres.model.dao.EditionDao;
import com.okres.model.entity.Edition;

import java.sql.Connection;
import java.util.List;

public class JDBCEditionDao implements EditionDao {

    private Connection connection;

    public JDBCEditionDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Edition entity) {

    }

    @Override
    public Edition findById(int id) {
        return null;
    }

    @Override
    public List<Edition> findAll() {
        return null;
    }

    @Override
    public void update(Edition entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void close() {

    }
}
