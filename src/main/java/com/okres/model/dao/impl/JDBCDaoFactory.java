package com.okres.model.dao.impl;

import com.okres.model.dao.DaoFactory;
import com.okres.model.dao.EditionDao;
import com.okres.model.dao.PaymentDao;
import com.okres.model.dao.ReaderDao;

import javax.sql.DataSource;

public class JDBCDaoFactory extends DaoFactory {

    private DataSource dataSource = ConnectionPoolHolder.getDataSource();
    @Override
    public ReaderDao createReaderDao() {
        return null;
    }

    @Override
    public EditionDao createEditionDao() {
        return null;
    }

    @Override
    public PaymentDao createPaymentDao() {
        return null;
    }
}
