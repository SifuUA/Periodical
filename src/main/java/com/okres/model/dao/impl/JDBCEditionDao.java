package com.okres.model.dao.impl;

import com.okres.model.dao.EditionDao;
import com.okres.model.dao.mapper.EditionMapper;
import com.okres.model.entity.Edition;
import com.okres.model.service.PropertyHolder;
import org.apache.commons.fileupload.FileItem;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author O.Kres
 * @version 1.0
 * @project Periodical
 * @since 1/13/2019
 */

public class JDBCEditionDao implements EditionDao {
    private Connection connection;
    private PropertyHolder propertyHolder = new PropertyHolder();
    private static Logger logger = Logger.getLogger(JDBCEditionDao.class);

    JDBCEditionDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Edition edit, FileItem file) {
        try {
            PreparedStatement preparedStatement = connection.
                    prepareCall(propertyHolder.getPropValues("insert.into.edition"));
            preparedStatement.setString(1, edit.getEditionName());
            preparedStatement.setInt(2, edit.getCategory());
            preparedStatement.setBinaryStream(3, file.getInputStream(), (int) file.getSize());
            preparedStatement.setInt(4, edit.getPrice());
            preparedStatement.setString(5, edit.getNotation());
            preparedStatement.execute();
        } catch (SQLException | IOException e) {
            logger.error("Cant insert edition: " + e);
        }
    }

    @Override
    public List<Edition> findAll() {
        ResultSet resultSet;
        EditionMapper mapper = new EditionMapper();
        List<Edition> editions = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareCall(propertyHolder.getPropValues("select.all.edition"));
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
                editions.add(mapper.extractFromResultSet(resultSet));
        } catch (SQLException | IOException e) {
            logger.error("Cant find all editions: " + e);
        }
        return editions;
    }

    @Override
    public void delete(int id) throws SQLException {
        try {
            connection.setAutoCommit(false);
            PreparedStatement paymentPreparedStatement =
                    connection.prepareStatement(propertyHolder.getPropValues("delete.from.payment"));
            PreparedStatement editionPreparedStatement =
                    connection.prepareStatement(propertyHolder.getPropValues("delete.from.edition"));
            paymentPreparedStatement.setInt(1, id);
            editionPreparedStatement.setInt(1, id);
            paymentPreparedStatement.executeUpdate();
            editionPreparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException | IOException e) {
            logger.error("Cant delete from payment and edition: " + e);
            connection.rollback();
        }
    }

    @Override
    public List<Edition> getLimitOfEditions(int start, int recordsPerPage) {
        List<Edition> editionList = new ArrayList<>();
        EditionMapper editionMapper = new EditionMapper();
        ResultSet resultSet;

        try {
            PreparedStatement preparedStatement =
                    connection.prepareCall(propertyHolder.getPropValues("select.limit.from.edition"));
            preparedStatement.setInt(1, start);
            preparedStatement.setInt(2, recordsPerPage);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                editionList.add(editionMapper.extractFromResultSet(resultSet));
            }
        } catch (SQLException | IOException e) {
            logger.error("Cant get limit from edition: " + e);
        }
        return editionList;
    }

    @Override
    public int getCountOfEditions() {
        ResultSet resultSet;
        int count = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareCall(propertyHolder.getPropValues("select.count.edition"));
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
                count = resultSet.getInt(1);
        } catch (SQLException | IOException e) {
            logger.error("Cant get count of edition" + e);
        }
        return count;
    }

    @Override
    public void create(Edition entity) {

    }

    @Override
    public Edition findById(int id) {
        return null;
    }

    @Override
    public void update(Edition entity) {

    }

    @Override
    public void close() {

    }
}
