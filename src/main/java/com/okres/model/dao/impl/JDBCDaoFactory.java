package com.okres.model.dao.impl;

import com.okres.model.dao.*;
import org.apache.log4j.Logger;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author O.Kres
 * @version 1.0
 * @project Periodical
 * @since 1/13/2019
 */

public class JDBCDaoFactory extends DaoFactory {
    private static Logger logger = Logger.getLogger(JDBCDaoFactory.class);
    private DataSource dataSource = ConnectionPoolHolder.getDataSource();

    private Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            logger.error("Cant get connection: " + e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public ReaderDao createReaderDao() {
        return new JDBCReaderDao(getConnection());
    }

    @Override
    public EditionDao createEditionDao() {
        return new JDBCEditionDao(getConnection());
    }

    @Override
    public PaymentDao createPaymentDao() {
        return new JDBCPaymentDao(getConnection());
    }

    @Override
    public EditionCategoryDao createEditionCategoryDao() {
        return new JDBCEditionCategoryDao(getConnection());
    }

}