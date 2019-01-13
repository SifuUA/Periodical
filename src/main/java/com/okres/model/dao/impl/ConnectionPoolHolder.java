package com.okres.model.dao.impl;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;

import javax.sql.DataSource;
import java.util.ResourceBundle;

/**
 * @author O.Kres
 * @version 1.0
 * @project Periodical
 * @since 1/13/2019
 */

class ConnectionPoolHolder {
    private static volatile DataSource dataSource = null;
    private static final String URL;
    private static final String USER;
    private static final String PASSWORD;

    static {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("db_config");
        URL = resourceBundle.getString("url");
        USER = resourceBundle.getString("user");
        PASSWORD = resourceBundle.getString("password");
    }

    static DataSource getDataSource() {
        if (null == dataSource) {
            synchronized (ConnectionPoolHolder.class) {
                if (dataSource == null) {
                    MysqlConnectionPoolDataSource pooledDataSource = new MysqlConnectionPoolDataSource();
                    pooledDataSource.setUrl(URL);
                    pooledDataSource.setUser(USER);
                    pooledDataSource.setPassword(PASSWORD);
                    dataSource = pooledDataSource;
                }
            }
        }
        return dataSource;
    }
}
