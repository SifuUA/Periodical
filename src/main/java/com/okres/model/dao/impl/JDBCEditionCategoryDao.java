package com.okres.model.dao.impl;

import com.okres.model.dao.EditionCategoryDao;
import com.okres.model.entity.EditionCategory;

import java.sql.Connection;
import java.util.List;

public class JDBCEditionCategoryDao implements EditionCategoryDao {

    private Connection connection;

    public JDBCEditionCategoryDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(EditionCategory entity) {

    }

    @Override
    public EditionCategory findById(int id) {
        return null;
    }

    @Override
    public List<EditionCategory> findAll() {
        return null;
    }

    @Override
    public void update(EditionCategory entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void close() {

    }
}
