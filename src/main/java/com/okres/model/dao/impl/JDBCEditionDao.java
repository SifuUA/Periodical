package com.okres.model.dao.impl;

import com.okres.model.dao.EditionDao;
import com.okres.model.dao.mapper.EditionMapper;
import com.okres.model.entity.Edition;
import org.apache.commons.fileupload.FileItem;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCEditionDao implements EditionDao {

    private Connection connection;

    public JDBCEditionDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Edition edit, FileItem file) {
        try {
            PreparedStatement preparedStatement = connection.
                    prepareCall("INSERT INTO periodical.edition (name, category_id, image, price, notation) " +
                            "VALUES (?, ?, ?, ?, ?)");
            preparedStatement.setString(1, edit.getEditionName());
            preparedStatement.setInt(2, edit.getCategory());
            preparedStatement.setBinaryStream(3, file.getInputStream(), (int) file.getSize());
            preparedStatement.setInt(4, edit.getPrice());
            preparedStatement.setString(5, edit.getNotation());
            preparedStatement.execute();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
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
    public void delete(int id) throws SQLException {
        try {
            connection.setAutoCommit(false);
            PreparedStatement paymentPreparedStatement =
                    connection.prepareStatement("DELETE FROM periodical.payment WHERE edition_id=?");
            PreparedStatement editionPreparedStatement =
                    connection.prepareStatement("DELETE FROM periodical.edition WHERE id=?");
            paymentPreparedStatement.setInt(1, id);
            editionPreparedStatement.setInt(1, id);
            paymentPreparedStatement.executeUpdate();
            editionPreparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void close() {

    }

    @Override
    public List<Edition> getLimitOfEditions(int start, int recordsPerPage) {
        List<Edition> editionList = new ArrayList<>();
        EditionMapper editionMapper = new EditionMapper();
        ResultSet resultSet;

        try {
            PreparedStatement preparedStatement =
                    connection.prepareCall("SELECT * FROM periodical.edition LIMIT ?, ?");
            preparedStatement.setInt(1, start);
            preparedStatement.setInt(2, recordsPerPage);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                editionList.add(editionMapper.extractFromResultSet(resultSet));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return editionList;
    }

    @Override
    public int getCountOfEditions() {
        ResultSet resultSet;
        int count = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareCall("SELECT COUNT(*) FROM periodical.edition");
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
                count = resultSet.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
}
