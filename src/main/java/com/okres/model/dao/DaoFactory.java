package com.okres.model.dao;

import com.okres.model.dao.impl.JDBCDaoFactory;

/**
 * @author O.Kres
 * @version 1.0
 * @project Periodical
 * @since 1/13/2019
 */

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
