package com.okres.model.dao.impl;

import com.okres.model.dao.EditionDao;
import com.okres.model.entity.Edition;
import org.apache.commons.fileupload.FileItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

    @Override
    public void putNewEdition(String editionName, String category, int price, FileItem file) {
        try{
            PreparedStatement preparedStatement = connection.
                    prepareCall("INSERT INTO periodical.edition (name, category_id, image, price) " +
                            "VALUES (editionName,)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
