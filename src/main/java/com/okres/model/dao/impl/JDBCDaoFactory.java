package com.okres.model.dao.impl;

import com.okres.model.dao.*;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCDaoFactory extends DaoFactory {

    private DataSource dataSource = ConnectionPoolHolder.getDataSource();

    private Connection getConnection() {
        try {
            System.out.println(dataSource.toString());
            return dataSource.getConnection();
        } catch (SQLException e) {
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