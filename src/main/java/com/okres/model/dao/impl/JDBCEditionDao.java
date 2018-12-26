package com.okres.model.dao.impl;

import com.okres.model.dao.EditionDao;
import com.okres.model.dao.mapper.EditionMapper;
import com.okres.model.entity.Edition;
import org.apache.commons.fileupload.FileItem;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class    JDBCEditionDao implements EditionDao {

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
        ResultSet resultSet;
        EditionMapper mapper = new EditionMapper();
        List<Edition> editions = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareCall("SELECT * FROM periodical.edition");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
                editions.add(mapper.extractFromResultSet(resultSet));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return editions;
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
    public void putNewEdition(String editionName, int category, int price, FileItem file, String notation) {
        try {
            PreparedStatement preparedStatement = connection.
                    prepareCall("INSERT INTO periodical.edition (name, category_id, image, price, notation) " +
                            "VALUES (?, ?, ?, ?, ?)");
            preparedStatement.setString(1, editionName);
            preparedStatement.setInt(2, category);
            preparedStatement.setBinaryStream(3, file.getInputStream(), (int) file.getSize());
            preparedStatement.setInt(4, price);
            preparedStatement.setString(5, notation);
            preparedStatement.execute();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
