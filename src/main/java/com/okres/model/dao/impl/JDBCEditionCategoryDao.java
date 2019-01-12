package com.okres.model.dao.impl;

import com.okres.model.dao.EditionCategoryDao;
import com.okres.model.dao.mapper.EditionCategoryMapper;
import com.okres.model.entity.EditionCategory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        ResultSet resultSet;
        EditionCategoryMapper editionCategoryMapper = new EditionCategoryMapper();
        List<EditionCategory> editionCategoryList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareCall("SELECT * FROM periodical.edition_category");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                editionCategoryList.add(editionCategoryMapper.extractFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return editionCategoryList;
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
