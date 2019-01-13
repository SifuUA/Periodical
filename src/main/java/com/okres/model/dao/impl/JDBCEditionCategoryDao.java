package com.okres.model.dao.impl;

import com.okres.model.dao.EditionCategoryDao;
import com.okres.model.dao.mapper.EditionCategoryMapper;
import com.okres.model.entity.EditionCategory;
import com.okres.model.service.PropertyHolder;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author O.Kres
 * @version 1.0
 * @project Periodical
 * @since 1/13/2019
 */

public class JDBCEditionCategoryDao implements EditionCategoryDao {
    private Connection connection;
    private static Logger logger = Logger.getLogger(JDBCEditionCategoryDao.class);
    private PropertyHolder propertyHolder = new PropertyHolder();

    JDBCEditionCategoryDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<EditionCategory> findAll() {
        ResultSet resultSet;
        EditionCategoryMapper editionCategoryMapper = new EditionCategoryMapper();
        List<EditionCategory> editionCategoryList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement =
                    connection.prepareCall(propertyHolder.getPropValues("select.all.edition_category"));
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                editionCategoryList.add(editionCategoryMapper.extractFromResultSet(resultSet));
            }
        } catch (SQLException | IOException e) {
            logger.error("Cant execute query: " + e);
        }
        return editionCategoryList;
    }

    @Override
    public void create(EditionCategory entity) {
    }

    @Override
    public EditionCategory findById(int id) {
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