package com.okres.model.dao;

import com.okres.model.dao.impl.JDBCDaoFactory;
import com.okres.model.entity.EditionCategory;

public abstract class DaoFactory {

    private static DaoFactory daoFactory;

    public abstract ReaderDao createReaderDao();

    public abstract EditionDao createEditionDao();

    public abstract PaymentDao createPaymentDao();

    public abstract EditionCategoryDao createEditionCategoryDao();

    public static DaoFactory getInstance() {
        if (daoFactory == null) {
            synchronized (DaoFactory.class) {
                if (daoFactory == null) {
                    daoFactory = new JDBCDaoFactory();
                }
            }
        }
        return daoFactory;
    }
}
